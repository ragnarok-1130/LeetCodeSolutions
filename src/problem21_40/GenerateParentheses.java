package problem21_40;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        addParenthesis(result, "", 0, 0, n);
        return result;
    }

    private void addParenthesis(List<String> list, String origin, int openNum, int closeNum, int n) {
        if (closeNum == n) {
            //右括号数量为n时则表示有n对括号
            list.add(origin);
            return;
        }
        //左括号数量小于n时可尝试添加左括号
        if (openNum < n) {
            addParenthesis(list, origin + "(", openNum + 1, closeNum, n);
        }
        //右括号数量小于左括号数量时可尝试添加右括号
        if (closeNum < openNum) {
            addParenthesis(list, origin + ")", openNum, closeNum + 1, n);
        }
    }
}
