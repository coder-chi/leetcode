package record;

import record.impl.ProblemRecordServiceImpl;

import java.io.IOException;

/**
 * created by zhangzhiyuan in 2020/1/29
 */
public class Operate {

    private ProblemRecordService problemRecordService = new ProblemRecordServiceImpl();

    public static void main(String[] args) {
        new Operate().record(2);
    }

    private boolean record(int index) {
        long timestamp = System.currentTimeMillis();
        try {
            return problemRecordService.recordProblem(index, timestamp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
