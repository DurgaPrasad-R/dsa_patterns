/**
 * Optimized Brute Force Approach:
 * The algorithm fixes a starting index `i` and incrementally
 * expands the subarray using an ending index `j`.
 *
 * Instead of recalculating the sum for every subarray from scratch,
 * a running sum is maintained while extending the subarray.
 *
 * For each new element added to the subarray, the running sum
 * is updated and checked against the target value `k`.
 * If the sum equals `k`, the result counter is incremented.
 *
 * This approach ensures that all possible subarrays are examined
 * while avoiding unnecessary recomputation of sums.
 *
 * Time Complexity:
 * - O(n²), due to two nested loops iterating over the array.
 *
 * Space Complexity:
 * - O(1), since only a constant amount of extra space is used.
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, result = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) result += 1;
            }
        }

        return result;
    }
}