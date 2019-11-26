public class RomanToInteger {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'M':
                    if (i > 0 && chars[i - 1] == 'C') {
                        //当C之后出现M时  C为100 M为800
                        result += 800;
                    } else {
                        result += 1000;
                    }
                    break;
                case 'D':
                    if (i > 0 && chars[i - 1] == 'C') {
                        //当C之后出现D时  C为100 D为300
                        result += 300;
                    } else {
                        result += 500;
                    }
                    break;
                case 'C':
                    if (i > 0 && chars[i - 1] == 'X') {
                        //当X之后出现C时  X为10 C为80
                        result += 80;
                    } else {
                        result += 100;
                    }
                    break;
                case 'L':
                    if (i > 0 && chars[i - 1] == 'X') {
                        //当X之后出现L时  X为10 L为30
                        result += 30;
                    } else {
                        result += 50;
                    }
                    break;
                case 'X':
                    if (i > 0 && chars[i - 1] == 'I') {
                        //当I之后出现X时  I为1 X为8
                        result += 8;
                    } else {
                        result += 10;
                    }
                    break;
                case 'V':
                    if (i > 0 && chars[i - 1] == 'I') {
                        //当I之后出现V时  I为1 V为3
                        result += 3;
                    } else {
                        result += 5;
                    }
                    break;
                case 'I':
                    result += 1;
                    break;
                default:
                    return -1;
            }
        }
        return result;
    }
}
