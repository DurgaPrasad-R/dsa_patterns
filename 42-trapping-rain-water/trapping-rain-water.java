/**
 * 
 */

class Solution {
    public int trap(int[] height) {
        int waterTrapped = 0, n = height.length, leftMax = 0, rightMax = 0;
        int left = 0, right = n-1;
        
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(height[left], leftMax);
                waterTrapped += Math.max(0, leftMax - height[left]);
                left += 1;
            }
            else {
                rightMax = Math.max(height[right], rightMax);
                waterTrapped += Math.max(0, rightMax - height[right]);
                right -= 1;
            }
        }

        return waterTrapped;
    }
}