/**
 * Pre-Computing the left and Right Heights!
 *
 * First, we iterate from left to right to compute the maximum height
 * seen so far at each index and store it in the leftMaxVals array.
 *
 * Then, we iterate from right to left to compute the maximum height
 * seen so far at each index and store it in the rightMaxVals array.
 *
 * Finally, for each index, the water trapped is determined by the
 * minimum of leftMaxVals[i] and rightMaxVals[i] minus the current height.
 * Negative values are treated as zero. The sum over all indices gives
 * the total trapped water.
 *
 * Time Complexity:
 * - O(n), as each of the three passes over the array takes linear time.
 *
 * Space Complexity:
 * - O(n), due to the extra arrays used to store left and right maximums.
 */

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