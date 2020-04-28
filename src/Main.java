import problem21_40.NextPermutation;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] nums = new int[]{1, 3, 2};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
