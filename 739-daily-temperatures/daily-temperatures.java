class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
                int idx = stk.pop();
                result[idx] = i - idx;
            }
            stk.push(i);
        }
        return result;
    }
}