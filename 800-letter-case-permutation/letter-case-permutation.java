class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, "", result);
        return result;
    }

    public void backtrack(String s, int i, String temp, List<String> result) {
        if (i == s.length()) {
            result.add(temp);
            return;
        }

        if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
            backtrack(s, i + 1, temp + s.charAt(i), result);
            backtrack(s, i + 1, temp + (char)(s.charAt(i) - 32), result);
        }

        else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
            backtrack(s, i + 1, temp + s.charAt(i), result);
            backtrack(s, i + 1, temp + (char)(s.charAt(i) + 32), result);
        }

        else {
            backtrack(s, i + 1, temp + s.charAt(i), result);
        }
    }
}