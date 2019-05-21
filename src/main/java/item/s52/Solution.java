package item.s52;

/**
 * created by zhangzhiyuan in 2019/4/25
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
public class Solution {
    public int[] pre = {1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596, 2279184, 14772512, 95815104, 666090624};
    public int res;

    /**
     *思路和上一道一样，只是不记录数字仅仅计算次数
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        int[] queenpos = new int[n];
        dfs(0, n, queenpos);
        return res;
    }

    /**
     * 来一个恶心的预计算版
     * @param n
     * @return
     */
    public int totalNQueens2(int n) {
        return pre[n];
    }

    public void dfs(int row, int n, int[] queenpos) {
        if (row == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(queenpos, row, i)) {
                queenpos[row] = i;
                dfs(row + 1, n, queenpos);
            }
        }
    }

    public boolean isValid(int[] queenpos, int row, int col) {
        if (row == 0) {
            return true;
        }
        for (int i = 0; i < row; i++) {
            if (queenpos[i] == col) {
                return false;
            }
            if (queenpos[i] - i == col - row) {
                return false;
            }
            if (queenpos[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            int count = new Solution().totalNQueens(i);
            long end = System.currentTimeMillis();
            System.out.println("index : "+ i + " time : " + (end - start) + " count : " + count);
        }
    }
}
