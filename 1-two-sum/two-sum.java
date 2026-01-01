/**
 * This approach uses a HashMap to solve the Two Sum problem in a single pass.
 *
 * As we iterate through the array, we calculate the complement
 * (target − current number) for each element.
 *
 * If the complement already exists in the map, it means we have found
 * two numbers whose sum equals the target, so we return their indices.
 *
 * Otherwise, we store the current number along with its index in the map
 * for future lookups.
 *
 * Time Complexity:
 * - O(n), since each element is processed once and HashMap operations
 *   (insert and lookup) take constant time on average.
 *
 * Space Complexity:
 * - O(n), due to the extra space used by the HashMap to store values
 *   and their corresponding indices.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> valueIndexPairs = new HashMap<>();

        for(int i = 0;i<n;i++) {
            if (valueIndexPairs.containsKey(target - nums[i])) {
                return new int[] {valueIndexPairs.get(target - nums[i]), i};
            } else {
                valueIndexPairs.put(nums[i], i);
            }
        }
        return new int[] {-1,-1};
    }
}