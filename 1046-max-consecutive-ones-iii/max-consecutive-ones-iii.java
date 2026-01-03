/**
 * Optimized Brute Force Approach:
 * The algorithm fixes a starting index `i` and expands the subarray
 * using an ending index `j`.
 *
 * While expanding the subarray, it maintains a running count of zeroes.
 * If a zero is encountered, the zero counter is incremented.
 *
 * As long as the number of zeroes in the current subarray does not exceed
 * the allowed limit `k`, the length of the subarray is calculated and
 * compared with the maximum length found so far.
 *
 * Once the zero count exceeds `k`, the inner loop is terminated early
 * since extending the subarray further will only increase the number
 * of zeroes.
 *
 * Time Complexity:
 * - O(n²), due to two nested loops iterating over the array.
 *
 * Space Complexity:
 * - O(1), since no additional space proportional to input size is used.
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int zeroes = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeroes += 1;
                }
                if (zeroes <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }
}