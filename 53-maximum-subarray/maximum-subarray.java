/**
 * Kadane’s Algorithm:
 * The idea is to maintain a running sum (`currSum`)
 * that represents the maximum subarray sum ending
 * at the current index.
 *
 * At each element, a decision is made:
 * - Either start a new subarray from the current element, or
 * - Extend the existing subarray by adding the current element
 *
 * This is done by taking the maximum of:
 * - the current element itself
 * - the current element plus the previous running sum
 *
 * A separate variable (`maxSum`) keeps track of the
 * maximum subarray sum found so far.
 *
 * As the array is traversed, `maxSum` is updated whenever
 * a larger subarray sum is encountered.
 *
 * After processing all elements, `maxSum` contains the
 * maximum possible subarray sum and is returned.
 *
 * Time Complexity:
 * - O(n), since the array is traversed once.
 *
 * Space Complexity:
 * - O(1), as only constant extra space is used.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(nums[i], nums[i] + currSum);

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}