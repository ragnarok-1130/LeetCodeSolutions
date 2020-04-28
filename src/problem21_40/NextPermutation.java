package problem21_40;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i;
        int j;
        int minBigger = Integer.MAX_VALUE;
        int minBiggerIndex = -1;
        for (i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                //找出最小的大于nums[i - 1]的数
                for (j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1] && nums[j] < minBigger) {
                        minBigger = nums[j];
                        minBiggerIndex = j;
                    }
                }
                nums[minBiggerIndex] = nums[i - 1];
                nums[i - 1] = minBigger;
                break;
            }
        }
        if (minBiggerIndex != -1) {
            //对从i开始的子数组重新排序
            Arrays.sort(nums, i, nums.length);
        } else {
            for (i = nums.length - 1; i >= nums.length / 2; i--) {
                int temp = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = nums[i];
                nums[i] = temp;
            }
        }
    }

}
