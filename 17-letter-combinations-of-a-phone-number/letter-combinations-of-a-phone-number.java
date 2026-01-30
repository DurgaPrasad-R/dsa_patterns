class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        backtrack(0, digits, "", result);

        return result;
    }

    public void backtrack(int idx, String str, String temp, List<String> result) {
        if (idx == str.length()) {
            result.add(temp);
            return;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        for (char ch: map.get(str.charAt(idx)).toCharArray()) { 
            backtrack(idx + 1, str, temp + ch, result);
        }
    }
}