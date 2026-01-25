class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, n = nums.length;
        int minDiff = Integer.MAX_VALUE;

        for (int right = k - 1; right < n; right++) {
            minDiff = Math.min(minDiff, nums[right] - nums[left]);
            left += 1;
        }
        return minDiff;
    }
}