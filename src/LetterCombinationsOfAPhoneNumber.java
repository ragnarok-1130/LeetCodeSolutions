import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private final static String[][] NUMBER_CHARS = new String[][]{
            {" "},                  //0
            {},                     //1
            {"a", "b", "c"},        //2
            {"d", "e", "f"},        //3
            {"g", "h", "i"},        //4
            {"j", "k", "l"},        //5
            {"m", "n", "o"},        //6
            {"p", "q", "r", "s"},   //7
            {"t", "u", "v"},        //8
            {"w", "x", "y", "z"},   //9
    };

    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> result = null;
        for (char ch : chars) {
            int num = ch - '0';
            result = combineNextChar(result, num);
        }
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    public List<String> combineNextChar(List<String> combinations, int number) {
        List<String> result;
        if (number == 1) {
            return combinations;
        }
        if (combinations == null) {
            return Arrays.asList(NUMBER_CHARS[number]);
        } else {
            result = new ArrayList<>(combinations.size() * NUMBER_CHARS[number].length);
        }
        for (String ch : NUMBER_CHARS[number]) {
            for (String combine : combinations) {
                result.add(combine + ch);
            }
        }
        return result;
    }
}
