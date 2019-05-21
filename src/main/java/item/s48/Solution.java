package item.s48;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * created by zhangzhiyuan in 2019/4/23
 */
public class Solution {

    /**
     * 这个题必须装个逼了哈 100%击败
     * 推出的公式为(x, y) -> (y, n-1-x)
     * 由于不能用中间矩阵存储，变成了 (x, y) -> (y, x) -> (y, n-1-x) 先转置再镜像
     * 转置和镜像对称的写法比较值得看下，另外好像有人可以一遍for循环就做出来了，秀
     * 到时候再看下
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(a);
        System.out.println(a);
    }
}
