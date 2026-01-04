/**
 * Two Pointers Solution:
 *
 * The array is first sorted to allow efficient duplicate handling
 * and enable the two-pointer strategy.
 *
 * Two nested loops are used to fix the first two numbers:
 * - The outer loop fixes index `i`
 * - The inner loop fixes index `j`
 *
 * For each pair (nums[i], nums[j]), the problem is reduced
 * to finding two numbers in the remaining subarray whose sum
 * equals (target − nums[i] − nums[j]).
 *
 * Two pointers, `left` and `right`, are initialized at:
 * - left = j + 1
 * - right = end of the array
 *
 * The sum of the four elements is calculated using `long`
 * to prevent integer overflow.
 *
 * If the sum equals the target:
 * - A valid quadruplet is added to the result list
 * - Both pointers are moved inward
 * - Duplicate values are skipped to avoid repeated quadruplets
 *
 * If the sum is greater than the target:
 * - The `right` pointer is moved left to reduce the sum
 *
 * If the sum is less than the target:
 * - The `left` pointer is moved right to increase the sum
 *
 * Duplicate values for indices `i` and `j` are skipped to
 * ensure uniqueness in the result.
 *
 * Time Complexity:
 * - O(n^3), due to two nested loops and a linear two-pointer scan.
 *
 * Space Complexity:
 * - O(1) auxiliary space (excluding the output list),
 *   since no extra data structures proportional to input size are used.
 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = ((long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right]);

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if (sum > target) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }   
            }
        }
        
        return result;
    }
}