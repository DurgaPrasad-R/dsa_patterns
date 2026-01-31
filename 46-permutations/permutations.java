class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, 0);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, int idx) {
        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i : nums) {
                temp.add(i);
            }
            result.add(temp);
            return;
        }

        for (int i = idx ; i < nums.length; i++) {
            swap(nums, idx, i);
            backtrack(nums, result, idx + 1);
            swap(nums, idx, i);
        }
    }

    public void swap(int[] nums, int idx, int i) {
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
    }
}