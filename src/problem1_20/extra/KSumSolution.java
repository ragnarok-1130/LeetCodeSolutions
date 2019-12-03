package problem1_20.extra;

import java.util.*;

public class KSumSolution {
    public List<List<Integer>> kSum(int[] nums, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < k || k < 2) {
            return result;
        }
        //国际惯例 先排序
        Arrays.sort(nums);
        return kSum(nums, target, k, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 2) {
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                //跳过重复值
                if (left > start && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
            return result;
        } else {
            for (int i = start; i <= nums.length - k; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] * k > target || nums[nums.length - 1] < target) {
                    return result;
                }
                List<List<Integer>> kMinusOneResult = kSum(nums, target - nums[i], k - 1, i + 1);
                if (kMinusOneResult.size() != 0) {
                    for (List<Integer> kMinusOne : kMinusOneResult) {
                        List<Integer> combine = new ArrayList<>();
                        combine.add(nums[i]);
                        combine.addAll(kMinusOne);
                        result.add(combine);
                    }
                }
            }
            return result;
        }
    }
}
