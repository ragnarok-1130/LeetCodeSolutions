import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        //先将数组进行排序
        Arrays.sort(nums);
        //固定其中一个数
        int closestNum = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int num = nums[i] + nums[left] + nums[right];
                if (num > target) {
                    right--;
                }
                if (num < target) {
                    left++;
                }
                if (num == target) {
                    return target;
                }
                if (Math.abs(num - target) < Math.abs(closestNum - target)) {
                    closestNum = num;
                }
            }
        }
        return closestNum;
    }
}
