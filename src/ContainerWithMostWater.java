public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }
}
