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

        char ch = s.charAt(i);
        
        if (Character.isDigit(ch)) {
            backtrack(s, i + 1, temp + ch , result);
        } else {
            backtrack(s, i + 1, temp + Character.toLowerCase(ch), result);
            backtrack(s, i + 1, temp + Character.toUpperCase(ch), result);
        }
    }
}