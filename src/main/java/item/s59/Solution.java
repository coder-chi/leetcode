package item.s59;

/**
 * created by zhangzhiyuan in 2019/5/6
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class Solution {
    /**
     * 100%，还是有点小兴奋的
     * 因为是n阶矩阵，所以只需要判断一次就可以了。
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int high = 0;
        int low = n;
        int left = 0;
        int right = n;
        int index = 1;
        while (true) {
            if (left >= right) {
                break;
            }
            for (int i = left; i < right; i++) {
                result[high][i] = index;
                index++;
            }
            high++;
            for (int i = high; i < low; i++) {
                result[i][right - 1] = index;
                index++;
            }
            right--;
            for (int i = right - 1; i >= left; i--) {
                result[low-1][i] = index;
                index++;
            }
            low--;
            for (int i = low - 1; i >= high; i--) {
                result[i][left] = index;
                index++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().generateMatrix(4);
    }
}
