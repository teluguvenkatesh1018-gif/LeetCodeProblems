class Solution {
    public int maxOperations(int[] nums, int k) {
        int Count=0;
        int left=0;
        Arrays.sort(nums);
        int right=nums.length-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==k){
                Count++;
                left++;
                right--;
            }else if(sum<k){
                left++;
            }else{
                right--;
            }
        }return Count;
    }
}