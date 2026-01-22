class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean hasOdd = false;
        int result = 0;

        // Freq. of each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int val : map.values()) {
            if (val % 2 != 0) {
                result += val - 1;
                hasOdd = true;
            } else {
                result = result + val;
            }
        }

        if (hasOdd) result += 1;
        return result;
    }
}