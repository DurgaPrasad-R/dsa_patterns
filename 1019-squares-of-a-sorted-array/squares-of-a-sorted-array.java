class Solution {
    public int[] sortedSquares(int[] nums) {
        // Two Pointers

        int n = nums.length;
        int[] result = new int[n];

        int left = 0, right = n - 1;
        int i = n - 1;
        while (left <= right) {
            int leftVal = nums[left] < 0 ? 0 - nums[left] : nums[left];
            int rightVal = nums[right] < 0 ? 0 - nums[right] : nums[right];


            if (rightVal > leftVal) {
                result[i] = rightVal * rightVal;
                right -= 1;
            } else {
                result[i] = leftVal * leftVal;
                left += 1;
            }
            i -= 1;
        }
        return result;
    }
}