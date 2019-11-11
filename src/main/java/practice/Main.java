package practice;

import java.util.Random;

/**
 * created by zhangzhiyuan in 2019/5/30
 */
public class Main {
    public static void main(String[] args) {
        boolean b = checkAVG(38);
        System.out.println(b);
    }

    private static boolean checkAVG(int avg) {
        for (int i = 0; i < 1000; i++) {
            if (!check30(avg)) {
                return false;
            }
        }
        return true;
    }

    private static boolean check30(int avg) {
        int[] time = new int[60];
        double[] avg3 = new double[60];
        double[] avg10 = new double[60];
        int count = avg * 60;
        Random random = new Random(60);
        for (int i = 0; i < count; i++) {
            int second = random.nextInt(60);
            time[second]++;
        }
        for (int i = 0; i < 60; i++) {
            int a = 0;
            for (int j = 0; j < 3; j++) {
                a += time[(i + j) % 60];
            }
            avg3[i] = (double) a / 3.0;
        }

        for (int i = 0; i < 60; i++) {
            int a = 0;
            for (int j = 0; j < 10; j++) {
                a += time[(i + j) % 60];
            }
            avg10[i] = (double) a / 10.0;
        }

        for (int i = 0; i < 60; i++) {
            if (avg10[i] == 0) {
                return false;
            }
            double r = avg3[i] / avg10[i];
            if (r > 1.3 || r < 10.0 / 13.0) {
                return false;
            }
        }
        return true;
    }
}
