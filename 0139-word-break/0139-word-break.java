class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> set = new HashSet<>(wordDict);
        boolean dp[]= new boolean [s.length()+1];
        dp[0]=true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<=i-1;j++){
                if(dp[j]==true && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }return dp[s.length()];

    }
}