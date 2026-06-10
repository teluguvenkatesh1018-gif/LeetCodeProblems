import java.util.PriorityQueue;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int[] log2 = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }
        int K = log2[n] + 1;
        int[][] stMax = new int[n][K];
        int[][] stMin = new int[n][K];
        for (int i = 0; i < n; i++) {
            stMax[i][0] = nums[i];
            stMin[i][0] = nums[i];
        }
        for (int j = 1; j < K; j++) {
            int len = 1 << (j - 1);
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(stMax[i][j - 1], stMax[i + len][j - 1]);
                stMin[i][j] = Math.min(stMin[i][j - 1], stMin[i + len][j - 1]);
            }
        }
        java.util.function.BiFunction<Integer, Integer, Integer> getValue = (l, r) -> {
            int j = log2[r - l + 1];
            int maxVal = Math.max(stMax[l][j], stMax[r - (1 << j) + 1][j]);
            int minVal = Math.min(stMin[l][j], stMin[r - (1 << j) + 1][j]);
            return maxVal - minVal;
        };
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int l = 0; l < n; l++) {
            heap.offer(new int[]{getValue.apply(l, n - 1), l, n - 1});
        }
        long total = 0;
        for (int i = 0; i < k; i++) {
            int[] top = heap.poll();
            int val = top[0];
            int l = top[1];
            int r = top[2];
            total += val;
            if (r > l) {
                heap.offer(new int[]{getValue.apply(l, r - 1), l, r - 1});
            }
        }
        return total;
    }
}