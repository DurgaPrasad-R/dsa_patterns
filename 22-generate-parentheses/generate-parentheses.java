class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, "", result);
        return result;
    }

    public void backtrack(int n, int o, int c, String temp, List<String> result) {
        if (o + c == n * 2 && o == c) {
            result.add(temp);
            return;
        }

        if (o < n) {
            backtrack(n, o + 1, c, temp + "(", result);
        }

        if (c < o) {
            backtrack(n, o, c + 1, temp + ")", result);
        }
    }
}