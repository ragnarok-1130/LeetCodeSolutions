package problem1_20;

public class StringToIntegerATOI {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int negativeNum = 0;
        int positiveNum = 0;
        long result = 0;
        boolean isFirst = true;
        for (char ch : chars) {
            //过滤头部空格
            if (ch == ' ' && isFirst) {
                continue;
            }
            if (ch == '-' || ch == '+' || ch >= '0' && ch <= '9') {
                //只处理头部正负号  非头部则停止
                if (ch == '-' || ch == '+') {
                    if (isFirst) {
                        if (ch == '-') {
                            negativeNum++;
                        } else {
                            positiveNum++;
                        }
                        isFirst = false;
                        continue;
                    } else {
                        break;
                    }
                }
                isFirst = false;
                result = result * 10 + (ch - '0');
                if (result > Integer.MAX_VALUE && (positiveNum == 1 || positiveNum + negativeNum == 0)) {
                    //当值为正  且大于32位int最大值则返回Integer.MAX_VALUE
                    return Integer.MAX_VALUE;
                } else if (result > Integer.MAX_VALUE && negativeNum == 1) {
                    //当值为负  且小于32位int最小值则返回Integer.MIN_VALUE
                    return Integer.MIN_VALUE;
                }
                continue;
            }
            break;
        }
        if (negativeNum == 1) {
            result = 0 - result;
        }
        return (int) result;
    }
}
