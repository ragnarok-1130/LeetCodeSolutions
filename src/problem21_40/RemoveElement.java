package problem21_40;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        //记录非被删除元素数目  同时作为指向下一个非被删除元素应该放置的位置
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[count++] = nums[i];
        }
        return count;
    }
}
