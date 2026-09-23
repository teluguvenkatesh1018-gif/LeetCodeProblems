class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);
        for(char c:ransomNote.toCharArray()){
            int index = sb.indexOf(String.valueOf(c));
            if(index == -1){
                return false;
            }
            sb.deleteCharAt(index);
        }
        return true;
    }
}