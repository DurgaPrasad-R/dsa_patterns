/**
 * Sliding Window Solution:
 *
 * Two pointers, `left` and `right`, define the current window of elements.
 * A running sum is maintained for the window.
 *
 * Algorithm Steps:
 * 1. Expand the window by moving the `right` pointer and adding `nums[right]` to the sum.
 * 2. While the current sum is greater than or equal to the target:
 *    - Update the minimum length of a valid subarray.
 *    - Shrink the window from the left by removing `nums[left]` from the sum and incrementing `left`.
 * 3. Continue expanding with `right` until the end of the array.
 *
 * This ensures that each valid window is considered and the minimum length
 * is found without missing any subarrays.
 *
 * Time Complexity:
 * - O(n), since each element is added and removed at most once.
 *
 * Space Complexity:
 * - O(1), as only a few variables are used.
 *
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, left = 0, right = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        while (left <= right && right < n) {
            sum = sum + nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum = sum - nums[left];
                left += 1;
            }
            right += 1;
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLength;
        }
    }
}