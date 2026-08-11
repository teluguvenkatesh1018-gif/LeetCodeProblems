package utils;

public class SearchUtils {

    /**
     * Finds the first index in arr[left..right-1] where arr[index] >= target.
     * Returns -1 if no such index exists.
     */
    public static int lowerBound(long[] arr, long target, int left, int right) {
        int l = left, r = right - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
