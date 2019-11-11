package item.s115;

/**
 * created by zhangzhiyuan in 2019/8/29
 * 本题关键在于如何求出动态转移方程，效率极低需要再优化
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= t.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= s.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
