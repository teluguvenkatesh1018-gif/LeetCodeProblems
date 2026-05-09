class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {
            int top = layer, left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            int size = 2 * (bottom - top + right - left);
            int[] arr = new int[size];
            int idx = 0;

            for (int j = left; j <= right; j++) arr[idx++] = grid[top][j];
            for (int i = top + 1; i < bottom; i++) arr[idx++] = grid[i][right];
            for (int j = right; j >= left; j--) arr[idx++] = grid[bottom][j];
            for (int i = bottom - 1; i > top; i--) arr[idx++] = grid[i][left];

            int rot = k % size;
            idx = 0;

            for (int j = left; j <= right; j++)
                grid[top][j] = arr[(idx++ + rot) % size];

            for (int i = top + 1; i < bottom; i++)
                grid[i][right] = arr[(idx++ + rot) % size];

            for (int j = right; j >= left; j--)
                grid[bottom][j] = arr[(idx++ + rot) % size];

            for (int i = bottom - 1; i > top; i--)
                grid[i][left] = arr[(idx++ + rot) % size];
        }

        return grid;
    }
}