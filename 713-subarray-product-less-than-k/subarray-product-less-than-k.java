class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 0) return 0;
        int n = nums.length;
        int left = 0, right = 0;
        int result = 0;
        long prod = 1;
        
        while (right < n) {
            prod *= nums[right];

            while (prod >= k && left <= right) {
                prod /= nums[left];
                left++;
            }

            result += right - left + 1;
            right++;
        }

        return result;
    }
}