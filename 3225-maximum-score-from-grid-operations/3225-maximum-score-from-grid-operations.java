import java.util.*;

class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        if (n == 1) return 0;

        long[][] colSum = new long[n][n + 1];
        for (int c = 0; c < n; c++) {
            for (int r = 1; r <= n; r++) {
                colSum[c][r] = colSum[c][r - 1] + grid[r - 1][c];
            }
        }

        long[][] prevMax = new long[n + 1][n + 1];
        long[][] prevSuffixMax = new long[n + 1][n + 1];
        long[][] dp = new long[n + 1][n + 1];

        for (int i = 1; i < n; i++) {
            long[][] newDp = new long[n + 1][n + 1];

            for (int currH = 0; currH <= n; currH++) {
                for (int prevH = 0; prevH <= n; prevH++) {
                    long val = 0;

                    if (currH <= prevH) {
                        long extra = colSum[i][prevH] - colSum[i][currH];
                        val = prevSuffixMax[prevH][0] + extra;
                    } else {
                        long extra = colSum[i - 1][currH] - colSum[i - 1][prevH];
                        val = Math.max(
                                prevSuffixMax[prevH][currH],
                                prevMax[prevH][currH] + extra
                        );
                    }

                    newDp[currH][prevH] = val;
                }
            }

            dp = newDp;

            for (int currH = 0; currH <= n; currH++) {
                prevMax[currH][0] = dp[currH][0];
                for (int prevH = 1; prevH <= n; prevH++) {
                    long penalty = (prevH > currH) ? (colSum[i][prevH] - colSum[i][currH]) : 0;
                    prevMax[currH][prevH] = Math.max(
                            prevMax[currH][prevH - 1],
                            dp[currH][prevH] - penalty
                    );
                }

                prevSuffixMax[currH][n] = dp[currH][n];
                for (int prevH = n - 1; prevH >= 0; prevH--) {
                    prevSuffixMax[currH][prevH] = Math.max(
                            prevSuffixMax[currH][prevH + 1],
                            dp[currH][prevH]
                    );
                }
            }
        }

        long ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = Math.max(ans, dp[n][k]);
            ans = Math.max(ans, dp[0][k]);
        }

        return ans;
    }
}