import java.util.Stack;
public class Solution {
    public static boolean isValid(String s) {
        

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(': case '{': case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                default:
                    
                    return false;
            }
        }

        return stack.isEmpty();
    }

}