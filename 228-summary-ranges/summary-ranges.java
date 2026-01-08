/* Two Pointer/ Sliding Window Style:
 * The algorithm maintains a `left` pointer that marks the start
 * of the current range. A `right` pointer moves forward to detect
 * whether the sequence remains consecutive.
 *
 * The loop runs from index 1 up to and including `n` (one step beyond
 * the array), which allows the algorithm to flush the final range
 * without needing extra handling after the loop.
 *
 * A range is considered broken when either:
 * 1) `right` reaches the end of the array, or
 * 2) the current element is not consecutive
 *    (nums[right] != nums[right - 1] + 1).
 *
 * When a break is detected:
 * - If `left == right - 1`, the range consists of a single number,
 *   and that number is added directly to the result.
 * - Otherwise, a range in the form "start->end" is added.
 *
 * After committing the range, the `left` pointer is moved to `right`
 * to begin tracking the next range.
 *
 * This approach ensures each element is visited exactly once.
 *
 * Time Complexity:
 * - O(n), since the array is scanned in a single pass.
 *
 * Space Complexity:
 * - O(1) extra space (excluding the output list).
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;

        if (n == 0) return result;

        int left = 0;
        for (int right = 1; right <= n; right++) {
            if (right == n || nums[right] - 1 != nums[right - 1]) {
                if (left == right - 1) {
                    result.add(nums[left]+"");
                } else {
                    result.add(nums[left]+"->"+nums[right-1]);
                }
                left = right;
            }
        }

        return result;
    }
}