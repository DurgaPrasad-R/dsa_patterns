class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, left = 0, right = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        while (left <= right && right < n) {
            sum = sum + nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum = sum - nums[left];
                left += 1;
            }
            right += 1;
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLength;
        }
    }
}