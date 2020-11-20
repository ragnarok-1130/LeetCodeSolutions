package problem21_40;//You are given an integer array nums sorted in ascending order, and an integer
//target.
//
// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [
//0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// If target is found in the array return its index, otherwise, return -1.
//
//
// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3:
// Input: nums = [1], target = 0
//Output: -1
//
//
// Constraints:
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// All values of nums are unique.
// nums is guranteed to be rotated at some pivot.
// -10^4 <= target <= 10^4
//
// Related Topics Array Binary Search
// 👍 6248 👎 546


//leetcode submit region begin(Prohibit modification and deletion)
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            }
            if (nums[left] > target && nums[right] < target) {
                break;
            }
            if (nums[left] <= nums[mid]) {
                //左边有序
                if (nums[mid] > target && nums[left] <= target) {
                    //位于左边
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                //右边有序
                if (nums[mid] < target && nums[right] >= target) {
                    //位于右边
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
