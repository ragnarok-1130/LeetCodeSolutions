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


    public boolean isValidV2(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null) {
            return false;
        }
        char[] sac = s.toCharArray();
        for (char c : sac) {
            switch (c) {
                case ')':

                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                default:
                    return false;
            }
        }
        // 栈清空则表示所有右括号均匹配到对应左括号
        return stack.empty();
    }
}
