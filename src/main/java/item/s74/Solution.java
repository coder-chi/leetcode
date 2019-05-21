package item.s74;

/**
 * created by zhangzhiyuan in 2019/5/20
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowN = matrix.length;
        if (rowN == 0) {
            return false;
        }
        int colN = matrix[0].length;
        if (colN == 0) {
            return false;
        }
        int low = 0;
        int high = rowN * colN - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            int num = getNumber(matrix, colN, mid);
            if (num == target) {
                return true;
            } else if (num < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public int getNumber(int[][] matrix, int colN, int n) {
        int r = n / colN;
        int c = n % colN;
        return matrix[r][c];
    }
}
