package problem1_20;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> leftParentheses = new Stack<>();
        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                leftParentheses.push(ch);
            } else if (ch == ')') {
                if (leftParentheses.size() == 0 || leftParentheses.pop() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (leftParentheses.size() == 0 || leftParentheses.pop() != '[') {
                    return false;
                }
            } else if (ch == '}') {
                if (leftParentheses.size() == 0 || leftParentheses.pop() != '{') {
                    return false;
                }
            }
        }
        if (leftParentheses.size() != 0) {
            return false;
        }
        return true;
    }
}
