import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num2 = diffMap.get(nums[i]);
            if (num2 != null) {
                return new int[]{num2, i};
            }
            diffMap.put(target - nums[i], i);
        }
        return null;
    }
}
