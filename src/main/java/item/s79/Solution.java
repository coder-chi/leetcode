package item.s79;

/**
 * created by zhangzhiyuan in 2019/5/20
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int rowN = board.length;
        if (rowN == 0) {
            return false;
        }
        int colN = board[0].length;
        if (colN == 0) {
            return false;
        }
        boolean[][] b = new boolean[rowN][colN];
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                boolean dfs = dfs(board, b, rowN, colN, i, j, 0, word);
                if (dfs == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] b, int rowN, int colN, int i, int j, int index, String word) {
        if (i < 0 || i >= rowN) {
            return false;
        }
        if (j < 0 || j >= colN) {
            return false;
        }
        if (b[i][j] == true) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        b[i][j] = true;
        boolean result = dfs(board, b, rowN, colN, i + 1, j, index + 1, word)
                || dfs(board, b, rowN, colN, i - 1, j, index + 1, word) ||
                dfs(board, b, rowN, colN, i, j + 1, index + 1, word) ||
                dfs(board, b, rowN, colN, i, j - 1, index + 1, word);
        b[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        boolean abcced = new Solution().exist(board, "ABCB");
        System.out.println(abcced);
    }
}
