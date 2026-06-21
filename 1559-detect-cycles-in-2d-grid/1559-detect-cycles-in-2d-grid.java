import utils.GridUtils;

class Solution {
    int m, n;
    boolean[][] vis;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (dfs(grid, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int x, int y, int px, int py, char ch) {
        vis[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + GridUtils.DX[d];
            int ny = y + GridUtils.DY[d];

            if (!GridUtils.isInBounds(nx, ny, m, n)) continue;
            if (grid[nx][ny] != ch) continue;

            if (!vis[nx][ny]) {
                if (dfs(grid, nx, ny, x, y, ch)) return true;
            } else if (nx != px || ny != py) {
                return true;
            }
        }

        return false;
    }
}
