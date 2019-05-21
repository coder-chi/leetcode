package item.s50;


/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * created by zhangzhiyuan in 2019/4/24
 */
public class Solution {
    /**
     * 二分查找，幂函数加快计算。
     * 一开始还打算用备忘录模式，后来仔细想想发现二分要个毛的备忘录……
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            return myPowPos(x, n);
        }
        return 1.0 / myPowPos(x, -n);
    }

    public double myPowPos(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == 2) {
            return x * x;
        }
        if (n % 2 == 0) {
            double d = myPowPos(x, n / 2);
            return d * d;
        }
        double d = myPowPos(x, n / 2);
        return d * d * x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.5, 15));
    }
}
