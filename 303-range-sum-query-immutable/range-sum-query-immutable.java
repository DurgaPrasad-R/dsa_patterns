/**
 * Prefix Sum Solution:
 *
 * A prefix sum array is precomputed during object construction,
 * where each index `i` stores the sum of elements from index 0
 * up to (but not including) index i of the original array.
 *
 * The prefix sum array is defined such that:
 * prefixSum[i] = nums[0] + nums[1] + ... + nums[i - 1]
 *
 * This allows the sum of any subarray [left, right] to be calculated
 * in constant time using the formula:
 * sumRange(left, right) = prefixSum[right + 1] - prefixSum[left]
 *
 * Precomputation is done once in the constructor, enabling fast
 * query responses without recomputing sums repeatedly.
 *
 * Time Complexity:
 * - Constructor: O(n), to build the prefix sum array.
 * - sumRange(): O(1), each query is answered in constant time.
 *
 * Space Complexity:
 * - O(n), due to the extra prefix sum array.
 */

class NumArray {
    int[] prefixSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n+1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */