package problem1_20;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        List<Character> substring = new ArrayList<>(s.length());
        int max = 0;
        int subLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            int position = substring.indexOf(ch);
            if (position >= 0) {
                if (substring.size() > position + 1) {
                    for (int j = 0; j <= position; j++) {
                        substring.remove(0);
                    }
                } else {
                    substring.clear();
                }
                subLen = substring.size();
            }
            substring.add(ch);
            subLen++;
            if (subLen > max) {
                max = subLen;
            }
        }
        return max;
    }
}
