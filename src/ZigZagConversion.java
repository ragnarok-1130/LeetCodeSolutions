import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        List<StringBuilder> stringBuilders = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            stringBuilders.add(new StringBuilder());
        }
        int i = 0;
        boolean addFlag = false;
        for (char ch : charArray) {
            if (i == 0 || i == numRows - 1) {
                addFlag = !addFlag;
            }
            if (addFlag) {
                stringBuilders.get(i++).append(ch);
            } else {
                stringBuilders.get(i--).append(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            result.append(stringBuilders.get(j));
        }
        return result.toString();
    }
}
