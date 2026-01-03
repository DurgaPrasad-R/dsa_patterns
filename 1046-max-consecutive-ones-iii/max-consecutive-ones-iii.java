/**
 * Sliding Window Solution:
 *
 * Two pointers, `left` and `right`, define a sliding window over the array.
 * A counter is maintained to track the number of zeroes present in the
 * current window.
 *
 * As the `right` pointer moves forward, elements are added to the window.
 * If a zero is encountered, the zero counter is incremented.
 *
 * If the number of zeroes in the window exceeds the allowed limit `k`,
 * the window is shrunk from the left by moving the `left` pointer forward
 * and updating the zero counter accordingly.
 *
 * Whenever the window contains at most `k` zeroes, the current window
 * length is compared with the maximum length found so far.
 *
 * This approach ensures that all valid windows are considered efficiently
 * without reprocessing elements.
 * Time Complexity:
 * - O(n), since each element enters and leaves the window at most once.
 * Space Complexity:
 * - O(1), as only a constant amount of extra space is used.
 */
 
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0, left = 0, right = 0, zeroes = 0;
        
        while (left <= right && right < n) {
            int val = nums[right];

            if (val == 0) {
                zeroes += 1;
            }

            if (zeroes <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            } 
            while (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes -= 1;
                }
                left += 1;
            }
            right += 1;
        }

        return maxLength;
    }
}