/* 
 * Reverse-Based Array Rotation Approach:
 *
 * The goal is to rotate the array to the right by k steps.
 * This is achieved using a sequence of three in-place reversals.
 *
 * First, the value of k is reduced using k % n to handle
 * cases where k is greater than the array length.
 *
 * The algorithm works as follows:
 *
 * 1. Reverse the first (n - k) elements of the array.
 * 2. Reverse the last k elements of the array.
 * 3. Reverse the entire array.
 *
 * These three reversals rearrange the elements such that
 * the last k elements move to the front while preserving
 * the relative order of all elements.
 *
 * This approach avoids using extra space and performs
 * all operations directly on the input array.
 *
 * Time Complexity:
 * - O(n), where n is the length of the array.
 *
 * Space Complexity:
 * - O(1), as the rotation is done in-place.
 */

class Solution {
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        if (k > 0 && n > 0) {
            k = k % n;
            reverse(nums, 0, n - 1 - k);
            reverse(nums, n - k, n - 1);

            reverse(nums, 0, n - 1);
        }
    }
}