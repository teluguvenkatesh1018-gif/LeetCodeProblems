import java.util.*;

class Solution {
    private static final int[][] DIRS = {{1, 0}, {0, 1}};

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int cost = 0; cost <= k; cost++) {
                    if (dp[i][j][cost] == -1) continue;

                    for (int[] dir : DIRS) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= m || nj >= n) continue;

                        int val = grid[ni][nj];
                        int newCost = cost + (val == 0 ? 0 : 1);
                        if (newCost <= k) {
                            dp[ni][nj][newCost] = Math.max(
                                dp[ni][nj][newCost],
                                dp[i][j][cost] + val
                            );
                        }
                    }
                }
            }
        }

        int ans = -1;
        for (int cost = 0; cost <= k; cost++) {
            ans = Math.max(ans, dp[m - 1][n - 1][cost]);
        }

        return ans;
    }
}
