package record;

import java.io.IOException;
import java.util.List;

/**
 * created by zhangzhiyuan in 2020/1/29
 */
public interface ProblemRecordService {

    /**
     * 记录题号和解答时间
     * @param index
     * @param timestamp
     * @return
     */
    boolean recordProblem(int index, long timestamp) throws IOException;


    boolean recodeProblemTimes(int index, List<Long> timestampList) throws IOException;

    /**
     * 获取题目的解答时间列表
     * @param index
     * @return
     */
    List<Long> findProblemRecord(int index);
}
