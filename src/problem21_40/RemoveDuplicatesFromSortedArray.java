package problem21_40;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //记录非重复元素数目  同时作为指向下一个非重复元素应该放置的位置
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            nums[count++]=nums[i];
        }
        return count;
    }
}
