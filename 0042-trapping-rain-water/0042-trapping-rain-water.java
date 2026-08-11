class Solution {
    public int trap(int[] height) 
    {
        if (height == null || height.length < 3) return 0;

        int n= height.length;
        int left=1;
        int right=n-2;
        int lMax=height[left-1];
        int rMax=height[right+1];
        int res=0;
        
        while(left<=right)
        {
            if(rMax<=lMax)
            {
                int water=rMax-height[right];
                if(water>0)
                {
                    res=res + water;
                }
                rMax=Math.max(rMax,height[right]);
                right=right-1;
            }
            else
            {
               int water=lMax-height[left];
                if(water>0)
            {
                res=res + water;
            }
            lMax= Math.max(lMax,height[left]);
            left=left+1;
        }
        
    }
    return res;
    }
}