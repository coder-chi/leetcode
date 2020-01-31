package item.s200;

/**
 * created by zhangzhiyuan in 2020/1/24
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int length = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, row, length);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j, int row, int length) {
        if (i < 0 || j < 0 || i == row || j == length) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        bfs(grid, i - 1, j, row, length);
        bfs(grid, i + 1, j, row, length);
        bfs(grid, i, j - 1, row, length);
        bfs(grid, i, j + 1, row, length);
    }
}
