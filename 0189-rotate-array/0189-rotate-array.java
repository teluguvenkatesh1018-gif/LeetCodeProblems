import utils.ArrayUtils;

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        ArrayUtils.reverseSubarray(nums, n - k, n - 1);
        ArrayUtils.reverseSubarray(nums, 0, n - k - 1);
        ArrayUtils.reverseSubarray(nums, 0, n - 1);
    }
}
