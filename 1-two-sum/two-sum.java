/**
 * To apply the two-pointer approach, the array must be sorted.
 * Since sorting changes the original indices, we store each number
 * along with its original index.
 *
 * We use a 2D array where:
 * - The first element of each row represents the value
 * - The second element represents the original index
 *
 * After sorting this array by value, we apply the two-pointer technique
 * and return the stored original indices when the target sum is found.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[][] sortedNums = new int[n][2];
        for(int i = 0;i<n;i++) {
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }

        Arrays.sort(sortedNums, (a,b)->(a[0]-b[0]));
        
        // initialize left and right pointers
        int left = 0, right = n - 1;

        while (left < right) {
            if (sortedNums[left][0] + sortedNums[right][0] < target) {
                left += 1;
            }

            else if (sortedNums[left][0] + sortedNums[right][0] == target) {
                return new int[] {sortedNums[left][1], sortedNums[right][1]};
            }

            else {
                right -= 1;
            }
        }
        

        return new int[] {-1,-1};
    }
}