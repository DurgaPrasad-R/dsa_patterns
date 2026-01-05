/**
 * Dutch National Flag algorithm:
 * Three pointers are used to partition the array into different regions:
 * - `left` marks the boundary for placing 0s
 * - `mid` is used to traverse the array
 * - `right` marks the boundary for placing 2s
 *
 * The array is conceptually divided into four regions:
 * - indices [0 ... left - 1] contain all 0s
 * - indices [left ... mid - 1] contain all 1s
 * - indices [mid ... right] are unexplored
 * - indices [right + 1 ... n - 1] contain all 2s
 *
 * While traversing the array using the `mid` pointer:
 * - If the current element is 1, it is already in the correct region,
 *   so `mid` is incremented.
 *
 * - If the current element is 0, it is swapped with the element at `left`,
 *   expanding the 0s region. Both `left` and `mid` are incremented.
 *
 * - If the current element is 2, it is swapped with the element at `right`,
 *   expanding the 2s region. Only `right` is decremented because the
 *   swapped element at `mid` needs to be re-evaluated.
 *
 * This process continues until all elements are processed.
 *
 * Time Complexity:
 * - O(n), since each element is examined at most once.
 *
 * Space Complexity:
 * - O(1), as the sorting is done in-place without extra memory.
 */

class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;


        while (mid <= right) {
            if (nums[mid] == 1) {
                mid += 1;
            } else if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;
                left += 1;
                mid += 1;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right -= 1;
            }
        }
    }
}