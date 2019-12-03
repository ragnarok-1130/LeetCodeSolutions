package problem1_20;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    //官方解法  无需转化为字符串  耗时更少
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int reversed = 0;
        for (int i = x; i != 0; i /= 10) {
            reversed = reversed * 10 + i % 10;
        }
        return reversed == x;
    }
}
