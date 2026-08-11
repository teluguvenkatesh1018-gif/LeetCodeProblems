import utils.ArrayUtils;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ArrayUtils.swap2D(matrix, i, j, j, i);
            }
        }

        for (int i = 0; i < n; i++) {
            ArrayUtils.reverseSubarray(matrix[i], 0, n - 1);
        }
    }
}
