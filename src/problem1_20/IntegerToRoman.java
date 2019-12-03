package problem1_20;

public class IntegerToRoman {
    private final static String[][] ROMAN_NUMBER = new String[][]{
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
    };

    public String intToRoman(int num) {
        if (num > 3999 || num < 1) {
            return "Out of range";
        }
        String result = "";
        int i = 0;
        while (num != 0) {
            result = ROMAN_NUMBER[i++][num % 10] + result;
            num /= 10;
        }
        return result;
    }
}
