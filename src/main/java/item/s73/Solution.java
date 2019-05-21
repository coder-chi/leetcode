package item.s73;

/**
 * created by zhangzhiyuan in 2019/5/18
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法
 */
public class Solution {

    /**
     * 落到第一行 第一列 并用单独的两个值判断第一行第一列是否需要置零
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int m = matrix.length, n = matrix[0].length;
        boolean row = false, col = false;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        row = true;
                    else if (j == 0)
                        col = true;
                    else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                if (i == 0 && row == true || j == 0 && col == true || matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
        return;
    }
}
