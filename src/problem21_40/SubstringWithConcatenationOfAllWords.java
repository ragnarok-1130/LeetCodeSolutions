package problem21_40;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        //计数  记录每个单词可用次数
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();
        //最大起始位置
        int maxIndex = s.length() - words.length * wordLen;
        for (int i = 0; i <= maxIndex; i++) {
            int j = 0;
            Map<String, Integer> seenWordsMap = new HashMap<>();
            for (; j < words.length; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (wordsMap.containsKey(word)) {
                    seenWordsMap.put(word, seenWordsMap.getOrDefault(word, 0) + 1);
                    if (seenWordsMap.get(word) > wordsMap.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j == words.length) {
                result.add(i);
            }
        }
        return result;
    }


    public List<Integer> findSubstringSlow(String s, String[] words) {
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
