package item.s357;

/**
 * created by zhangzhiyuan in 2019/11/18
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 10;
        int muls = 9;
        if (n > 10) {
            n = 10;
        }
        for (int i = 1; i < n; i++) {
            muls *= (10 - i);
            res += muls;
        }
        return res;
    }
}
