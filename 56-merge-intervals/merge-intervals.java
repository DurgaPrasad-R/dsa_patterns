/**
 * Sorting-based Approach:
 * The intervals are first sorted based on their start times.
 * Sorting ensures that any overlapping intervals will appear
 * next to each other in the array.
 *
 * An index pointer `idx` is used to track the position of the
 * last merged interval in the result.
 *
 * The algorithm iterates through the intervals starting from
 * the second interval:
 *
 * - If the current interval overlaps with the interval at `idx`
 *   (i.e., the start of the current interval is less than or equal
 *   to the end of the previous interval), the intervals are merged
 *   by updating the end time to the maximum of both.
 *
 * - If the current interval does not overlap, `idx` is incremented
 *   and the current interval is placed as a new merged interval.
 *
 * After processing all intervals, only the merged portion of the
 * array is returned using `Arrays.copyOf`.
 *
 * Time Complexity:
 * - O(n log n), due to sorting the intervals.
 *
 * Space Complexity:
 * - O(1) auxiliary space (excluding the output array),
 *   as merging is done in-place.
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        // [1,10], [2,3], [4,8], [10,10], [11,12], [12,15], [16,18], [17,20]
        int n = intervals.length, idx = 0;
        if (n == 0) return intervals;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        for(int i = 1; i < n; i++) {
            if (intervals[idx][1] >= intervals[i][0]) {
                intervals[idx][1] = Math.max(intervals[i][1], intervals[idx][1]);
            } else {
                idx++;
                intervals[idx] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, idx + 1);
    }
}