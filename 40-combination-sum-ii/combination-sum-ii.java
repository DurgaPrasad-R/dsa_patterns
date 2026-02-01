class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findCombs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void findCombs(int[] candidates, int idx, int target, List<Integer> dataStr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(dataStr));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) return;
            dataStr.add(candidates[i]);
            findCombs(candidates, i + 1, target - candidates[i], dataStr, result);
            dataStr.remove(dataStr.size() - 1);
        }
    }
}