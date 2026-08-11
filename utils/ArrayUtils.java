package utils;

public class ArrayUtils {

    /**
     * Swaps two elements in a 1D array.
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Swaps two elements in a 2D array.
     */
    public static void swap2D(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    /**
     * Reverses elements in arr[left..right] in-place.
     */
    public static void reverseSubarray(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    /**
     * Flattens a 2D int grid into a 1D array (row-major order).
     */
    public static int[] flattenGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[m * n];
        int idx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                result[idx++] = val;
            }
        }
        return result;
    }
}
