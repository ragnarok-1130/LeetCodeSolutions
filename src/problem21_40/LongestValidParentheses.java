package problem21_40;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    //...()形式
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (chars[i - 1] == ')' && i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                    //(...)形式
                    dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                } else {
                    dp[i] = 0;
                }
            } else {
                dp[i] = 0;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
