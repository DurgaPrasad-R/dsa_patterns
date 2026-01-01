class Solution {
    public int trap(int[] height) {
        int waterTrapped = 0, n = height.length, lMax = 0, rMax = 0;

        int[] leftMaxVals = new int[n];
        int[] rightMaxVals = new int[n];
        
        for(int i=0;i<n;i++) {
            leftMaxVals[i] = lMax;
            if (height[i] > lMax) {
                lMax = height[i];
            }
        }

        for(int i=n-1;i>=0;i--) {
            rightMaxVals[i] = rMax;
            if (height[i] > rMax) {
                rMax = height[i];
            }
        }
        
        for(int i = 0;i<n;i++) {
            waterTrapped += Math.max(0, Math.min(leftMaxVals[i], rightMaxVals[i]) - height[i]);
        }
        
        return waterTrapped;
    }
}