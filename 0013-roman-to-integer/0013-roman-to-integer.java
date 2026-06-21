import java.util.HashMap;
import java.util.Map;
public class Solution {
    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string must not be null or empty");
        }

        Map<Character,Integer> ToInt=new HashMap<>();
        ToInt.put('I',1);
        ToInt.put('V',5);
        ToInt.put('X',10);
        ToInt.put('L',50);
        ToInt.put('C',100);
        ToInt.put('D',500);
        ToInt.put('M',1000);

        int total=0;
        int preVal=0;

        for (int i=s.length()-1;i>=0;i--){
            Integer value=ToInt.get(s.charAt(i));
            if (value == null) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + s.charAt(i));
            }
            int curVal=value;

            if(curVal<preVal){
                total-=curVal;
            }else{
                total+=curVal;
            }
            preVal=curVal;
        }
        return total;


    }
    public static void main(String[] args){
        String roman="III";
    }
}