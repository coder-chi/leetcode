package item.s85;

import java.util.Stack;

/**
 * created by zhangzhiyuan in 2019/7/25
 */
public class Solution {

    /**
     * 动态规划解法
     * @link https://blog.csdn.net/maxiaotiaoti/article/details/62230381
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] h = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            l[i] = 0;
            r[i] = n;
            h[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    h[j] += 1;
                } else {
                    h[j] = 0;
                }

                if (matrix[i][j] == '1') {
                    l[j] = Math.max(l[j], cur_left);
                } else {
                    l[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    r[j] = Math.min(r[j], cur_right);
                } else {
                    r[j] = n;
                    cur_right = j;
                }
            }

            for (int j = 0; j < n; j++) {
                result = Math.max(result, (r[j] - l[j]) * h[j]);
            }
        }
        return result;
    }

    /**
     * 栈解法
     * @param matrix
     * @return
     */
    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxarea = Math.max(maxarea, leetcode84dp(dp));
        }
        return maxarea;
    }

    private int leetcode84dp(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
