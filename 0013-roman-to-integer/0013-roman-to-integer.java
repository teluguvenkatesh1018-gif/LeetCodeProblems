import java.util.HashMap;
import java.util.Map;
public class Solution {
    public static int romanToInt(String s) {
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
            int curVal=ToInt.get(s.charAt(i));

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