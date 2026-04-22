class Solution {
    public int maxArea(int[] height) 
    {
        int left =0;
        int n= height.length;
        int right= n-1;
        int maxArea =0;
        while(left<right)
        {
            int min= Math.min(height[left],height[right]);
            int width= right-left;
           int area=min * width;
            maxArea= Math.max(area,maxArea);

        if(height[left]<height[right])
        {
           
          left++;
        }
        else right--;
        }
        return maxArea;
     }
}