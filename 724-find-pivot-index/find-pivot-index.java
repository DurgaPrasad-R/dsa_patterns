class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length, totalSum = 0, sum = 0;
        
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        for(int i = 0; i < n; i++) {
            int leftSum = sum;
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) return i;
            sum = sum + nums[i];
        }

        return -1;
    }
}