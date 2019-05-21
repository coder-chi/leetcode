package item.s54;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/4/28
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class Solution {

    /**
     * 击败100%，完全自己做出来，没有任何辅助
     * 仅仅是一个模拟，难点是判断边界，快的原因可能是提前返回了吧
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int high = 0;
        int low = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        while (true) {
            if (left >= right) {
                break;
            }
            for (int i = left; i < right; i++) {
                result.add(matrix[high][i]);
            }
            high++;
            if (high >= low) {
                break;
            }
            for (int j = high; j < low; j++) {
                result.add(matrix[j][right - 1]);
            }
            right--;
            if (left >= right) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                result.add(matrix[low - 1][i]);
            }
            low--;
            if (high >= low) {
                break;
            }
            for (int j = low - 1; j >= high; j--) {
                result.add(matrix[j][left]);
            }
            left++;
            if (left >= right) {
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4, 5}, {5, 6, 7, 8, 9}, {9, 10, 11, 12, 13}, {14, 15, 16, 17, 18}};
        List<Integer> list = new Solution().spiralOrder(a);
        System.out.println(list);
    }
}
