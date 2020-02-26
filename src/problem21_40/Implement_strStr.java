package problem21_40;

public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        if (needleChars.length == 0) {
            return 0;
        }
        int index = 0, i = 0;
        int lastMatchHead = -1;
        //是否本次匹配中第一次保存位置
        boolean isFirst = true;
        for (; i < haystackChars.length; i++) {
            //如果匹配中遇到能再次匹配头部则保存此位置 若匹配失败从此重新开始匹配
            if (index != 0 && haystackChars[i] == needleChars[0] && isFirst) {
                lastMatchHead = i;
                isFirst = false;
            }
            if (haystackChars[i] == needleChars[index]) {
                index++;
                if (index == needleChars.length) {
                    break;
                }
            } else {
                index = 0;
                if (lastMatchHead != -1) {
                    //将i移动到上次匹配的位置前一位（因为后续还要i++）
                    i = lastMatchHead - 1;
                    lastMatchHead = -1;
                    isFirst = true;
                }
            }
        }
        if (i == haystackChars.length && index != needleChars.length) {
            return -1;
        }
        return i - index + 1;
    }

}
