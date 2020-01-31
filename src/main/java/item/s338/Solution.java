package item.s338;

/**
 * created by zhangzhiyuan in 2019/11/20
 */
public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int i = 0, b = 1;
        while (b <= num) {
            while (i < b && i + b <= num) {
                dp[i + b] = dp[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }
        return dp;
    }
}
