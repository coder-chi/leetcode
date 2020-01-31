package record.impl;

import com.dianping.vc.sdk.codec.JsonCodec;
import com.google.common.collect.Maps;
import record.ProblemRecord;
import record.ProblemRecordService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created by zhangzhiyuan in 2020/1/29
 */
public class ProblemRecordServiceImpl implements ProblemRecordService {

    private String filePath = "record.txt";

    @Override
    public boolean recordProblem(int index, long timestamp) throws IOException {
        File file = getRecordFile();
        String s = getFileString(file);
        Map<Integer, ProblemRecord> integerProblemRecordMap = convertString2Map(s);

        ProblemRecord record = integerProblemRecordMap.getOrDefault(index, buildProblemRecord(index));
        record.getTimestampList().add(timestamp);
        integerProblemRecordMap.put(index, record);
        String newS = JsonCodec.encode(integerProblemRecordMap);

        writeStringToFile(newS, file);
        return true;
    }

    @Override
    public boolean recodeProblemTimes(int index, List<Long> timestampList) throws IOException {
        File file = getRecordFile();
        String s = getFileString(file);
        Map<Integer, ProblemRecord> integerProblemRecordMap = convertString2Map(s);

        ProblemRecord record = integerProblemRecordMap.getOrDefault(index, buildProblemRecord(index));
        List<Long> timestamps = record.getTimestampList();
        for (long timestamp : timestampList) {
            timestamps.add(timestamp);
        }
        integerProblemRecordMap.put(index, record);
        String newS = JsonCodec.encode(integerProblemRecordMap);

        writeStringToFile(newS, file);
        return false;
    }

    private ProblemRecord buildProblemRecord(int index) {
        ProblemRecord problemRecord = new ProblemRecord();
        problemRecord.setIndex(index);
        problemRecord.setTimestampList(new ArrayList<>());
        return problemRecord;
    }

    @Override
    public List<Long> findProblemRecord(int index) {
        return null;
    }

    /**
     * 将字符串转换为Map
     * @param s
     * @return
     */
    private Map<Integer, ProblemRecord> convertString2Map(String s) {
        Map<Integer, ProblemRecord> integerProblemRecordMap = JsonCodec.converseMap(s, Integer.class, ProblemRecord.class);
        if (integerProblemRecordMap == null) {
            return Maps.newHashMap();
        }
        return integerProblemRecordMap;
    }

    /**
     * 获取文件
     * @return
     */
    private File getRecordFile() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /**
     * 根据文件获取整个字符串
     * @param file
     * @return
     * @throws IOException
     */
    private String getFileString(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buf = new byte[1024];
        int num;
        StringBuilder stringBuilder = new StringBuilder();
        while ((num = fileInputStream.read(buf)) != -1) {
            stringBuilder.append(new String(buf, 0, num));
        }
        fileInputStream.close();
        String s = stringBuilder.toString();
        return s;
    }

    /**
     * 将文件写入
     * @param file
     */
    private void writeStringToFile(String s, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] outPutBytes = s.getBytes();
        fileOutputStream.write(outPutBytes);
        fileOutputStream.close();
    }

}
