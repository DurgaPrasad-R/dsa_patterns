class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        return findSets(nums, 0, new ArrayList<>(), result);
    }

    public List<List<Integer>> findSets(int[] nums, int idx, List<Integer> dataStr, List<List<Integer>> result) {
        result.add(new ArrayList<>(dataStr));
        for (int i = idx; i < nums.length; i++) {
            // preventing duplicates
            if (i > idx && nums[i] == nums[i - 1]) continue;
            dataStr.add(nums[i]);
            findSets(nums, i + 1, dataStr, result);
            dataStr.remove(dataStr.size() - 1);
        }
        return result;
    }
}