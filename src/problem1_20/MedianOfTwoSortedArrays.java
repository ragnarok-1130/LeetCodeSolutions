package problem1_20;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int size1 = nums1.length, size2 = nums2.length;
        int totalSize = size1 + size2;
        int mid = totalSize / 2;
        boolean isEven = totalSize % 2 != 0;
        int[] tempArr = new int[totalSize];
        while (i < size1 || j < size2) {
            if (i == size1) {
                tempArr[i + j] = nums2[j];
                j++;
                continue;
            }
            if (j == size2) {
                tempArr[i + j] = nums1[i];
                i++;
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                tempArr[i + j] = nums1[i];
                i++;
            } else {
                tempArr[i + j] = nums2[j];
                j++;
            }
        }
        return isEven ? tempArr[mid] : (tempArr[mid - 1] + tempArr[mid]) / 2.0;
    }
}
