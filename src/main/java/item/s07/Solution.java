package item.s07;

/**
 * created by zhangzhiyuan in 2019/5/6
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution {
    /**
     * 翻转整数，实在没什么干货，不想解了
     * @param x
     * @return
     */
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            result = 0;
        return (int)result;
    }
}
