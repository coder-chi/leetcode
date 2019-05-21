package item.s51;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/4/25
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class Solution {
    /**
     * 先来默一个八皇后的一般解法（递归）
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //第i个位置存放的数表示row行的时候n的列
        int[] queenList = new int[n];
        placeQueen(queenList, 0, n, res);
        return res;
    }

    public void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int col = 0; col < n; col++) {
                    if (queenList[i] == col) {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                list.add(str);
            }
            res.add(list);
        }

        for (int col = 0; col < n; col++) {
            if (isValid(queenList, row, col)) {
                queenList[row] = col;
                placeQueen(queenList, row + 1, n, res);
            }
        }
    }

    private boolean isValid(int[] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            if (pos == col) {
                return false;
            }
            if (pos - i == col - row) {
                return false;
            }
            if (pos + i == col + row) {
                return false;
            }
        }
        return true;
    }


}
