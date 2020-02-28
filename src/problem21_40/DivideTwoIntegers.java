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

}
