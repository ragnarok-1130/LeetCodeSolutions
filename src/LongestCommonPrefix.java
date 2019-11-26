public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                int j = 0;
                while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                    j++;
                }
                prefix = strs[0].substring(0, j);
                if (prefix.isEmpty()) {
                    break;
                }
            }
            return prefix;
        }
    }
}
