import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        // s字符串所用栈
        Stack<Character> ss = new Stack<>();
        // t字符串所用栈
        Stack<Character> st = new Stack<>();

        if (s != null) {
            char[] sca = s.toCharArray();
            for (char c : sca) {
                if (c == '#') {
                    if (!ss.empty()) {
                        ss.pop();
                    }
                    continue;
                }
                ss.push(c);
            }
        }
        if (t != null) {
            char[] tca = t.toCharArray();
            for (char c : tca) {
                if (c == '#') {
                    if (!st.empty()) {
                        st.pop();
                    }
                    continue;
                }
                st.push(c);
            }
        }
        if (ss.size() != st.size()) {
            return false;
        }
        while (!ss.empty() && !st.empty()) {
            if (!ss.pop().equals(st.pop())) {
                return false;
            }
        }
        return true;
    }
}
