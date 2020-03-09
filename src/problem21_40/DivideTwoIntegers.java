package problem21_40;

public class DivideTwoIntegers {
    /**
     * 注意int的范围
     */
    public int divide(int dividend, int divisor) throws Exception {
        if (divisor == 0) {
            throw new Exception("divided by zero!");
        }
        if (dividend >= 0) {
            return divisor > 0 ? divideNegative(-dividend, -divisor) : -divideNegative(-dividend, divisor);

        } else {
            return divisor > 0 ? -divideNegative(dividend, -divisor) : divideNegative(dividend, divisor);
        }
    }

    /**
     * 负数间除法   仅除数与被除数均为负数时有效
     *
     * @param dividend
     * @param divisor
     * @return
     */
    private int divideNegative(int dividend, int divisor) {
        int result = 0;
        int temp = 0;
        while (dividend - temp <= divisor) {
            temp += divisor;
            result++;
            if (result == Integer.MAX_VALUE || result == Integer.MIN_VALUE) {
                break;
            }
        }
        return result;
    }

    public int divideVerTwo(int dividend, int divisor) throws Exception {
        if (divisor == 0) {
            throw new Exception("divided by zero!");
        }
        //异或运算  判断运算结果符号
        boolean sign = (dividend ^ divisor) >= 0;

        int result = divideFast(dividend, divisor);
        if (result == Integer.MIN_VALUE && sign) {
            return Integer.MAX_VALUE;
        }
        return sign ? -result : result;
    }

    /**
     * 以负数计算 防止超出int范围
     * @param dividend
     * @param divisor
     * @return
     */
    private int divideFast(int dividend, int divisor) {
        //全部转为负数进行运算
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        if (dividend == 0 || dividend > divisor) {
            return 0;
        }
        if (dividend == divisor) {
            return -1;
        }

        int result = -1;
        int temp = divisor;
        int half = dividend >> 1;
        while (dividend < temp) {
            if (temp <= half) {
                break;
            }
            temp = temp << 1;
            result = result << 1;
        }
        return result + divideFast(dividend - temp, divisor);
    }

}
