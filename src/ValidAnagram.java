import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Map<Character, Integer> countMap = new HashMap<>(s.length());
        for (char c : sChars) {
            Integer count = countMap.get(c);
            if (count == null) {
                count = 0;
            }
            countMap.put(c, ++count);
        }

        for (char c : tChars) {
            Integer count = countMap.get(c);
            if (count == null) {
                return false;
            }
            --count;
            if (count == 0) {
                countMap.remove(c);
            } else {
                countMap.put(c, count);
            }
        }
        return countMap.size() == 0;
    }

    /**
     * 性能优化版本
     */
    public boolean isAnagramV2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Map<Character, Integer> countMap = new HashMap<>(s.length());
        for (char c : sChars) {
            Integer count = countMap.get(c);
            if (count == null) {
                count = 0;
            }
            countMap.put(c, ++count);
        }

        for (char c : tChars) {
            Integer count = countMap.get(c);
            if (count == null) {
                return false;
            }
            countMap.put(c, --count);
        }
        for (Integer num : countMap.values()) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 使用数组实现
     */
    public boolean isAnagramV3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] letterNum = new int[26];

        for (char c : sChars) {
            letterNum[c - 'a']++;
        }

        for (char c : tChars) {
            letterNum[c - 'a']--;
        }
        for (Integer num : letterNum) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
