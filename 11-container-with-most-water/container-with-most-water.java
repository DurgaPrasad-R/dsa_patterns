class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxRes = Integer.MIN_VALUE;

        while (left < right) {  
            maxRes = Math.max(maxRes, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxRes;
    }
}