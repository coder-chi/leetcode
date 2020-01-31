package item.s329;

/**
 * created by zhangzhiyuan in 2020/1/28
 */
public class Solution {
    private int[][] dp;

    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int height = matrix[0].length;
        this.matrix = matrix;
        this.dp = new int[row][height];
        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < height; j++) {
                max = Math.max(max, longestPath(i, j));
            }
        }
        return max;
    }

    private int longestPath(int i, int j) {
        if (i < 0 || i >= dp.length || j < 0 || j >= dp[0].length) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int up = i > 0 && matrix[i][j] < matrix[i - 1][j] ? longestPath(i - 1, j) : 0;
        int down = i < dp.length - 1 && matrix[i][j] < matrix[i + 1][j] ? longestPath(i + 1, j) : 0;
        int left = j > 0 && matrix[i][j] < matrix[i][j - 1] ? longestPath(i, j - 1) : 0;
        int right = j < dp[0].length - 1 && matrix[i][j] < matrix[i][j + 1] ? longestPath(i, j + 1) : 0;
        int path = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        dp[i][j] = path;
        return path;
    }

    public static void main(String[] args) {
        int[][] m = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        new Solution().longestIncreasingPath(m);
    }
}
