/**
 * Two Pointer Approach:
 *
 * Two pointers are initialized at the beginning and end of the array. As we traverse
 * inward, we maintain the maximum height seen so far from the left (leftMax) and
 * from the right (rightMax).
 *
 * At each step, we compare the heights at the left and right pointers:
 * - If the left height is smaller or equal, the amount of water trapped at the left
 *   index depends only on leftMax, since the right boundary is guaranteed to be taller.
 * - Otherwise, the amount of water trapped at the right index depends only on rightMax.
 *
 * For the chosen side, we update the corresponding maximum height and add the
 * trapped water at that index to the total.
 *
 * This process continues until the two pointers meet, ensuring that each index
 * is processed exactly once.
 *
 * Time Complexity:
 * - O(n), as the array is traversed only once using two pointers.
 *
 * Space Complexity:
 * - O(1), since no extra data structures are used apart from a few variables.
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