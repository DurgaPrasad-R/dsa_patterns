/**
 * Binary Search on the answer:
 * The key observation is that the minimum ship capacity must be:
 * - At least the maximum weight of any single package
 * - At most the sum of all package weights
 *
 * We define a helper method `computeDays` that simulates the shipping
 * process for a given ship capacity.
 *
 * In `computeDays`:
 * - We iterate through the weights sequentially.
 * - We keep adding packages to the current day until the capacity
 *   would be exceeded.
 * - If adding a package exceeds the capacity, we increment the day
 *   count and start a new day with the current package.
 *
 * This helper method returns the total number of days required
 * to ship all packages using the given capacity.
 *
 * In the main method, binary search is applied on the range
 * [maxWeight, sumOfWeights].
 *
 * For each mid-capacity:
 * - If the number of required days is less than or equal to the
 *   given limit, we try to minimize the capacity by searching
 *   the left half.
 * - Otherwise, we increase the capacity by searching the right half.
 *
 * The binary search continues until the minimum valid capacity
 * is determined.
 *
 * Time Complexity:
 * - O(n log S), where:
 *   n = number of packages
 *   S = sum of all package weights
 *
 * Space Complexity:
 * - O(1), since only constant extra space is used.
 */

class Solution {
    public int computeDays(int[] weights, int capacity) {
        int days = 1;
        int currW = 0;

        for (int w: weights) {
            if (currW + w > capacity) {
                days += 1;
                currW = w;
            } else {
                currW += w;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for (int i: weights) {
            low = Math.max(low, i);
            high += i;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (computeDays(weights, mid) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}