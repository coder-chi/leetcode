package item.s08;

/**
 * created by zhangzhiyuan in 2019/5/6
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 */
public class Solution {
    /**
     * 简单，但是复杂，有空可以看看，仔细想一想
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        int length = str.length();
        while (index < length) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            if (Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }
}
