package item.s392;

import java.util.concurrent.*;

/**
 * created by zhangzhiyuan in 2019/12/20
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sl = s.length();
        if (sl == 0) {
            return true;
        }
        int tl = t.length();
        if (tl == 0) {
            return false;
        }
        boolean[][] dp = new boolean[sl + 1][tl + 1];
        for (int j = 0; j < tl + 1; j++) {
            dp[0][j] = true;
        }
        for (int i = 1; i < sl + 1; i++) {
            for (int j = 1; j < tl + 1; j++) {
                if (dp[i][j - 1] || (dp[i - 1][j - 1] && s.charAt(i - 1) == t.charAt(j - 1))) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[sl][tl];
    }

    public static void main(String[] args) {

        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        completableFuture.completeExceptionally(new RuntimeException("test"));
        try {
            completableFuture.get(1000, TimeUnit.MILLISECONDS);
            System.out.println(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
