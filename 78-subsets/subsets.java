class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result, 0);
        return result;
    }

    /** 
    * @params: 
    * nums[] - list of nums
    * temp - to maintains current subset
    * result - to store every subset
    * idx - include/exculde the current index 
    */
    public void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result, int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        backtrack(nums, temp, result, idx + 1);
        temp.remove(temp.size() - 1);
        backtrack(nums, temp, result, idx + 1);
    }
}