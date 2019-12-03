package problem1_20;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] charArray = s.toCharArray();
        //插入字符#使得无论长度为奇偶都能以同样方式处理  无需区分
        char[] newCharArray = new char[charArray.length * 2 + 1];
        int[] LPS = new int[newCharArray.length];
        int p = 0;
        newCharArray[p] = '#';
        LPS[p++] = 0;
        //初始化转化后字符数组newCharArray和回文长度数组LPS
        for (char c : charArray) {
            newCharArray[p] = c;
            LPS[p++] = 1;
            newCharArray[p] = '#';
            LPS[p++] = 0;
        }
        int currentPosition = 0;
        int centerPosition = 0;
        int centerRightPosition = 0;
        //初始状态最大LPS为1   回文中心点为1   此时回文串为字符本身
        int maxLPS = 1;
        int maxLPSCenterPosition = 1;
        while (currentPosition < newCharArray.length) {
            int leftPosition = currentPosition - 1;
            int rightPosition = currentPosition + 1;

            int leftCenterPosition = 2 * centerPosition - currentPosition;
            if (currentPosition < centerRightPosition) {
                LPS[currentPosition] = Math.min(LPS[leftCenterPosition], centerRightPosition - currentPosition);
                //此处LPS无需除以2是因为#号未统计在LPS中
                rightPosition = currentPosition + LPS[currentPosition] +1;
                leftPosition = 2 * currentPosition - rightPosition;
            }
            //中心扩张
            while (leftPosition >= 0 && rightPosition < newCharArray.length && leftPosition < rightPosition && newCharArray[leftPosition] == newCharArray[rightPosition]) {
                if (rightPosition > centerRightPosition) {
                    centerRightPosition = rightPosition;
                    centerPosition = currentPosition;
                }
                //不计算#号
                if (newCharArray[leftPosition] == '#') {
                    rightPosition++;
                    leftPosition--;
                    continue;
                }
                //左右各扩张一个字符 故+2
                LPS[currentPosition] = LPS[currentPosition] + 2;
                if (LPS[currentPosition] > maxLPS) {
                    maxLPSCenterPosition = currentPosition;
                    maxLPS = LPS[currentPosition];
                }
                rightPosition++;
                leftPosition--;
            }
            currentPosition++;
        }

        int left = (maxLPSCenterPosition - maxLPS) / 2, right = (maxLPSCenterPosition + maxLPS) / 2;
        return s.substring(left, right);
    }
}
