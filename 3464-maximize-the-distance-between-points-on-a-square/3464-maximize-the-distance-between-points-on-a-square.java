import java.util.*;
import utils.SearchUtils;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];

        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) pos[i] = x;
            else if (x == side) pos[i] = side + y;
            else if (y == side) pos[i] = 3L * side - x;
            else pos[i] = 4L * side - y;
        }

        Arrays.sort(pos);
        long perimeter = 4L * side;

        long[] posExt = new long[2 * n];
        for (int i = 0; i < n; i++) {
            posExt[i] = pos[i];
            posExt[i + n] = pos[i] + perimeter;
        }

        long left = 0, right = 2L * side, ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canPlace(posExt, n, k, mid, perimeter)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) ans;
    }

    private boolean canPlace(long[] posExt, int n, int k, long d, long perimeter) {
        for (int i = 0; i < n; i++) {
            int count = 1;
            long first = posExt[i];
            long last = first;

            for (int pick = 1; pick < k; pick++) {
                long target = last + d;
                int next = SearchUtils.lowerBound(posExt, target, i + 1, i + n);
                if (next == -1) break;
                last = posExt[next];
                count++;
            }

            if (count == k) {
                if (last - first <= perimeter - d) {
                    return true;
                }
            }
        }
        return false;
    }
}
