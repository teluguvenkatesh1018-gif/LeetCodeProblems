class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int sign = 1;
        int res = 0;
        int idx = 0;
        int MAX_INT = Integer.MAX_VALUE;
        int MIN_INT = Integer.MIN_VALUE;

        while (idx < n && s.charAt(idx) == ' ') {
            idx++;
        }

        if (idx < n && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            sign = (s.charAt(idx) == '-') ? -1 : 1;
            idx++;
        }

        while (idx < n && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';

            if (res > MAX_INT / 10 || (res == MAX_INT / 10 && digit > 7)) {
                return (sign == 1) ? MAX_INT : MIN_INT;
            }

            res = res * 10 + digit;
            idx++;
        }

        return res * sign;
    }
}
