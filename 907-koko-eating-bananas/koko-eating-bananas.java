/**
 * Binary Search on Answer Approach:
 *
 * This solution finds the minimum eating speed `k` such that
 * Koko can finish all banana piles within `h` hours.
 *
 * Observation:
 * - The eating speed must be at least 1.
 * - The maximum possible speed is the size of the largest pile.
 * - If Koko can finish eating at speed `k`,
 *   she can also finish at any speed greater than `k`.
 *   This monotonic behavior allows binary search.
 *
 * Helper Method — computeHours:
 * - Calculates the total hours required to eat all piles
 *   at a given eating speed.
 * - For each pile, the number of hours is computed using
 *   ceiling division:
 *     hours = (pile + speed - 1) / speed
 *
 * Main Algorithm:
 * 1. Determine the search range:
 *    - `low = 1` (minimum possible speed)
 *    - `high = max(piles)` (maximum pile size)
 *
 * 2. Perform binary search on the eating speed:
 *    - Compute `mid` as the current speed.
 *    - If Koko can finish within `h` hours at speed `mid`,
 *      try to reduce the speed by moving left (`high = mid - 1`).
 *    - Otherwise, increase the speed (`low = mid + 1`).
 *
 * 3. When the search ends, `low` represents the minimum
 *    valid eating speed.
 *
 * Time Complexity:
 * - O(n log m), where:
 *   n = number of piles
 *   m = maximum pile size
 *
 * Space Complexity:
 * - O(1), using constant extra space.
 */

class Solution {
    public long computeHours(int[] piles, int target) {
        int n = piles.length;
        long hours = 0;

        for (int i = 0; i < n; i++) {
            hours += piles[i] / target;

            if (piles[i] % target > 0) {
                hours += 1;
            }
        }
        
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int n = piles.length;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }

        int low = 1, high = max;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (computeHours(piles, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}