package item.s97;

/**
 * created by zhangzhiyuan in 2019/8/29
 * 自己在梳理了思路完全自己写的，还是有点小成就感的
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length = s3.length();
        int il = s1.length();
        int jl = s2.length();

        //检查
        if (length != il + jl) {
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < il; i++) {
            alpha[s1.charAt(i) - 'a']++;
        }
        for (int j = 0; j < jl; j++) {
            alpha[s2.charAt(j) - 'a']++;
        }
        for (int n = 0; n < s3.length(); n++) {
            alpha[s3.charAt(n) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }

        //dp
        boolean[][] dp = new boolean[il + 1][jl + 1];
        dp[0][0] = true;
        for (int i = 1; i <= il; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            if (!dp[i][0]) {
                break;
            }
        }
        for (int j = 1; j <= jl; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
            if (!dp[0][j]) {
                break;
            }
        }
        for (int i = 1; i <= il; i++) {
            for (int j = 1; j <= jl; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[il][jl];
    }

    public static void main(String[] args) {
        String s1 = "abb";
        String s2 = "aab";

        String s3 = "aababb";

        new Solution().isInterleave(s1, s2, s3);
    }
}
