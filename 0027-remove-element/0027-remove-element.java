class Solution {
    public int removeElement(int[] nums, int val) {
        int n= nums.length;
        int i=0;
        while(i<n){
            if(nums[i]==val){
                for(int j=i;j<=n-2;j++){
                    nums[j]=nums[j+1];
                }
                n--;
            }else{
                i++;
            }
        }
        return n;
    }
}