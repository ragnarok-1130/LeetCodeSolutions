package problem21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<String> stringList = Arrays.asList(words);
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i);
            if (prefixInArray(temp, stringList)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean prefixInArray(String s, List<String> words) {
        if (words.size() == 0) {
            return true;
        }
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() > s.length()) {
                continue;
            }
            if (s.startsWith(words.get(i))) {
                List<String> list = new ArrayList<>();
                if (i != 0) {
                    list.addAll(words.subList(0, i));
                }
                if (i < words.size() - 1) {
                    list.addAll(words.subList(i + 1, words.size()));
                }
                return prefixInArray(s.substring(words.get(i).length()), list);
            }
        }
        return false;
    }
}
