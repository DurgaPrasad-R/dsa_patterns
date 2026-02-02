class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] candidates, int idx, int target, List<Integer> temp, List<List<Integer>> result) {
        if (target <= 0 || idx == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(candidates[idx]);
        backtrack(candidates, idx, target - candidates[idx], temp, result);
        temp.remove(temp.size() - 1);
        backtrack(candidates, idx + 1, target, temp, result);
    }
}