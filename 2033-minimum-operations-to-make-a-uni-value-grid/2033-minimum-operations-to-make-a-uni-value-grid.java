import java.util.*;
import utils.ArrayUtils;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr = ArrayUtils.flattenGrid(grid);
        int size = arr.length;

        int rem = arr[0] % x;
        for (int val : arr) {
            if (val % x != rem) return -1;
        }

        Arrays.sort(arr);
        int median = arr[size / 2];

        int ops = 0;
        for (int val : arr) {
            ops += Math.abs(val - median) / x;
        }

        return ops;
    }
}
