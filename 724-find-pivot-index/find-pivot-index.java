class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preLeft = new int[n+1];
        int[] preRight = new int[n];

        for(int i = 1; i <= n; i++) {
            preLeft[i] = preLeft[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) preRight[i] = preLeft[n] - nums[i];
            else {
                preRight[i] = preRight[i - 1] - nums[i];
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (preRight[i] == preLeft[i]) return i;
        }
        return -1;
    }
}