class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] mapST = new int [256];
        int[] mapTS = new int [256];

        Arrays.fill(mapST,-1);
        Arrays.fill(mapTS,-1);

        for(int i=0;i<s.length();i++){
            int a = s.charAt(i);
            int b = t.charAt(i);

            if(mapST[a] != -1 && mapST[a] != b){
                return false;
            }
            if(mapTS[b] != -1 && mapTS[b] != a){
                return false;
            }

                mapST[a]=b;
                mapTS[b]=a;
        }
        return true;
    }
}