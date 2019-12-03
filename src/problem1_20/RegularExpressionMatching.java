package problem1_20;

public class RegularExpressionMatching {
    private Boolean[][] result;

    public boolean isMatch(String s, String p) {
        //长度+1防止越界
        result = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    public boolean dp(int i, int j, String s, String p) {
        boolean ans;
        if (result[i][j] != null) {
            return result[i][j];
        }
        //当pattern匹配完成且字符串也匹配完成则返回true
        if (j == p.length()) {
            return i == s.length();
        } else {
            boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                ans = dp(i, j + 2, s, p) || (firstMatch && dp(i + 1, j, s, p));
            } else {
                ans = firstMatch && dp(i + 1, j + 1, s, p);
            }
        }
        result[i][j] = ans;
        return ans;
    }

    public boolean dp2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            //初始化s长度为0时的数组
            if (p.charAt(i) == '*' && i > 0 && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                //如果是s[i]==p[j] 或者是对于元素匹配
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    //如果前一个元素不匹配 且不为任意元素
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */

                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * 回溯法
     *
     * @param s
     * @param p
     * @return
     */
    public boolean recursionSolution(String s, String p) {
        //当pattern匹配完成且字符串也匹配完成则返回true
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //比较子串第一个字符是否匹配
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //当pattern长度大于等于2且下一字符为*时
        if (p.length() >= 2 && p.charAt(1) == '*') {
            //此时可能有'*'号匹配0次  也可能第一个字符匹配可以继续匹配
            return recursionSolution(s, p.substring(2)) || (firstMatch && recursionSolution(s.substring(1), p));
        } else {
            //当第一个字符匹配且下一字符非'*'则继续匹配
            return firstMatch && recursionSolution(s.substring(1), p.substring(1));
        }
    }
}
