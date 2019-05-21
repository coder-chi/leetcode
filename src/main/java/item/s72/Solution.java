package item.s72;

/**
 * created by zhangzhiyuan in 2019/5/18
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class Solution {

    /**
     * 一道非常经典的动规题
     * https://blog.csdn.net/feliciafay/article/details/17502919 看一下人家的状态转移方程立刻就懂了
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = initDP(length1, length2);
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                dp[i][j] = checkDP(i, j, word1, word2, dp);
            }
        }
        return dp[length1][length2];
    }

    public int[][] initDP(int length1, int length2) {
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= length2; j++) {
            dp[0][j] = j;
        }
        return dp;
    }


    /**
     * 状态转移方程
     */
    public int checkDP(int i, int j, String word1, String word2, int[][] dp) {
        int min = Integer.MAX_VALUE;
        min = dp[i-1][j] + 1 < min ? dp[i - 1][j] + 1 : min;
        min = dp[i][j - 1] + 1 < min ? dp[i][j - 1] + 1 : min;
        int a = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
        min = a < min ? a : min;
        return min;
    }

    public static void main(String[] args) {
        int i = new Solution().minDistance("horse", "ros");
        System.out.println(i);
    }
}
