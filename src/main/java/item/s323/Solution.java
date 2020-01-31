package item.s323;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangzhiyuan in 2019/11/16
 */
public class Solution {

    public int coinChange(int[] coins,int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        new Solution().coinChange(coins, 11);
    }
}
