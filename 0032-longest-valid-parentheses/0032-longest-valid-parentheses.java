import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);  // base index
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stk.push(i);
            } else { // c == ')'
                stk.pop();
                
                if (stk.isEmpty()) {
                    stk.push(i);  // reset base
                } else {
                    maxLen = Math.max(maxLen, i - stk.peek());
                }
            }
        }
        
        return maxLen;
    }
}
