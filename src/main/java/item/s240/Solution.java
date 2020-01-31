package item.s240;

/**
 * created by zhangzhiyuan in 2020/1/25
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int length = matrix[0].length;
        int i = row - 1, j = 0;
        while (i >= 0 && j < length) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
