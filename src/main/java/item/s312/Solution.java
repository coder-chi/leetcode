package item.s312;

/**
 * created by zhangzhiyuan in 2019/12/16
 */
public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length + 2;
        int[] numss = new int[length];
        numss[0] = 1;
        for (int i = 0; i < length - 2; i++) {
            numss[i + 1] = nums[i];
        }
        numss[length - 1] = 1;

        int[][] dp = new int[length][length];

        for (int len = 2; len < length; len++) {
            for (int i = 0; i < length - len; i++) {
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], numss[i] * numss[k] * numss[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][length -1];
    }

    public static void main(String[] args) {
        int[] sum = {3, 1, 5, 8};
        new Solution().maxCoins(sum);
    }
}
