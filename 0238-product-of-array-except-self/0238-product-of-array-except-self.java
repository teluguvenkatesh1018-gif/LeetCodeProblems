class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        int zerocount = 0;
        int totalproduct = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zerocount++;
            } else {
                totalproduct *= nums[i];
            }
        }

        if (zerocount > 1) {
            Arrays.fill(result, 0);
        } else if (zerocount == 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    result[i] = totalproduct;
                } else {
                    result[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = totalproduct / nums[i];
            }
        }

        return result;
    }
}
