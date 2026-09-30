class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            int prevS = s.indexOf(s.charAt(i));
            int prevT = t.indexOf(t.charAt(i));

            if(prevS != prevT){
                return false;
            }
        }
        return true;
    }
}