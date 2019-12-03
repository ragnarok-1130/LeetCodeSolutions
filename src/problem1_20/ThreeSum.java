package problem1_20;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //先将数组进行排序
        Arrays.sort(nums);
        //固定其中一个数
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1, target = 0 - nums[i];
            //nums[i]>target时不存在
            if (nums[i] > target) {
                break;
            }
            //相同结果不再重复计算
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
