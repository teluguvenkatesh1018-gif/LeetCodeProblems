class Solution {
    public int arraySign(int[] nums) {
        int Ncnt = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0; 
            } else if (nums[i] < 0) {
                Ncnt++; 
            }
        }

        if (Ncnt % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
