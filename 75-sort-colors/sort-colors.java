/**
 * Counting Approach:
 *
 * Since the array contains only three distinct values (0, 1, and 2),
 * we first count the frequency of each value.
 *
 * A count array of size 3 is used where:
 * - count[0] stores the number of 0s
 * - count[1] stores the number of 1s
 * - count[2] stores the number of 2s
 *
 * In the first pass, we iterate through the input array and
 * populate the count array based on the value at each index.
 *
 * In the second phase, we overwrite the original array:
 * - First, we fill in all the 0s
 * - Then, all the 1s
 * - Finally, all the 2s
 *
 * An index pointer is used to keep track of the position
 * where the next value should be placed.
 *
 * Time Complexity:
 * - O(n), as the array is traversed a constant number of times.
 *
 * Space Complexity:
 * - O(1), since the count array has a fixed size of 3
 *   and does not grow with input size.
 */

class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        int n = nums.length, idx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count[0] += 1;
            } else if (nums[i] == 1) {
                count[1] += 1;
            } else {
                count[2] += 1;
            }
        }

        while (count[0] > 0) {
            nums[idx] = 0;
            idx += 1;
            count[0] -= 1;
        }

        while (count[1] > 0) {
            nums[idx] = 1;
            idx += 1;
            count[1] -= 1;
        }

        while (count[2] > 0) {
            nums[idx] = 2;
            idx += 1;
            count[2] -= 1;
        }
    }
}