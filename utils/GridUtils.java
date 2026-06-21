package utils;

public class GridUtils {

    public static final int[] DX = {1, -1, 0, 0};
    public static final int[] DY = {0, 0, 1, -1};

    /**
     * Returns true if (x, y) is within an m x n grid.
     */
    public static boolean isInBounds(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
