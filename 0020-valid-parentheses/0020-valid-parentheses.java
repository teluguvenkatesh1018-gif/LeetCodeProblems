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
                    // Optional: handle unexpected characters
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "{[()]}";
        System.out.println("Is valid? " + isValid(test));
    }
}