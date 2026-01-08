/**
 * Single Pass, Index Controlled Solution:
 * The algorithm iterates through the array using a loop index `i`.
 * At each iteration, the current element is treated as the start
 * of a potential range.
 *
 * A variable `s` stores the starting value of the current range.
 * The algorithm then advances `i` forward as long as the next element
 * is consecutive (i.e., nums[i + 1] == nums[i] + 1).
 *
 * Once the consecutive sequence ends, there are two possible cases:
 * 1) If the start value `s` is equal to the current value `nums[i]`,
 *    the range contains only one number, and that number is added
 *    directly to the result list.
 * 2) Otherwise, a range string in the format "start->end" is added,
 *    where `start` is `s` and `end` is `nums[i]`.
 *
 * The loop then continues from the next index after the processed range.
 *
 * By incrementing the loop index inside the `while` loop, the algorithm
 * ensures that each element is processed exactly once.
 *
 * Time Complexity:
 * - O(n), since each element is visited only once.
 *
 * Space Complexity:
 * - O(1) extra space (excluding the output list).
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;

        if (n == 0) return result;

        for (int i = 0; i < n; i++) {
            int s = nums[i];

            while (i + 1 < n && nums[i+1] - 1 == nums[i]) {
                i++;
            }

            if (s == nums[i]) {
                result.add(s+"");
            } else {
                result.add(s+"->"+nums[i]);
            }
        }
        return result;
    }
}