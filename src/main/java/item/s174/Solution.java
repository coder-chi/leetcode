package item.s174;

/**
 * created by zhangzhiyuan in 2019/11/28
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null) {
            return 0;
        }
        int rLength = dungeon.length;
        int lLength = dungeon[0].length;
        int[][] dp = new int[rLength][lLength];
        dp[rLength - 1][lLength - 1] = cal(dungeon[rLength - 1][lLength - 1]);
        for (int i = lLength - 2; i >= 0; i--) {
            dp[rLength - 1][i] = cal(dungeon[rLength - 1][i], dp[rLength - 1][i + 1]);
        }
        for (int i = rLength - 2; i >= 0; i--) {
            dp[i][lLength - 1] = cal(dungeon[i][lLength - 1], dp[i + 1][lLength - 1]);
        }
        for (int i = rLength - 2; i >= 0; i--) {
            for (int j = lLength - 2; j >= 0; j--) {
                dp[i][j] = cal(dungeon[i][j], dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }

    private int cal(int metric) {
        if (metric > 0) {
            return 1;
        }
        return 1 - metric;
    }

    private int cal(int metric, int dp) {
        int result = dp - metric;
        if (result <= 0) {
            return  1;
        }
        return result;
    }

    private int cal(int metric, int dpDown, int dpRight) {
        int result = Math.min(dpDown, dpRight) - metric;
        if (result <= 0) {
            return 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] du = {{0, 0, 0}, {1, 1, -1}};
        int i = new Solution().calculateMinimumHP(du);
        System.out.println(1);
    }
}
