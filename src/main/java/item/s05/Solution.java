package item.s05;

/**
 * created by zhangzhiyuan in 2019/5/3
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Solution {

    /**
     * dp解法，我实在太菜了，这题完全照别人写的，之后要回来看
     * 还有O(n)的马拉车算法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i < s.length() - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    start = i;
                    max = 2;
                }
            }
        }
        //l为子串长度
        for (int l = 3; l <= s.length(); l++) {
            //枚举子串起点
            for (int i = 0; i + l - 1 < s.length(); i++) {
                int j = l + i - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    max = l;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        String babad = new Solution().longestPalindrome("babad");
        System.out.println(babad);
    }
}
