/**
 * Sorting-based Approach:
 * The input array is first sorted in ascending order.
 * After sorting, consecutive numbers appear next to each other.
 *
 * The algorithm iterates through the sorted array and
 * counts the length of consecutive sequences:
 * - If the current number is exactly 1 greater than the previous,
 *   the current sequence length is incremented.
 * - If the current number is equal to the previous (duplicate),
 *   it is skipped.
 * - Otherwise, the current sequence is broken and reset to 1.
 *
 * At each step, the maximum sequence length found so far
 * is updated.
 *
 * Time Complexity:
 * - O(n log n), because sorting dominates.
 *
 * Space Complexity:
 * - O(1), ignoring the input array sorting.
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0 || n == 1) return n;

        int maxLength = 1, currLength = 1;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                    currLength += 1;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                currLength = 1;
            }
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}