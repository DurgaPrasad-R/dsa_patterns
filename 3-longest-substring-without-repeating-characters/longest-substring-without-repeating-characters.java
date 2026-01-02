class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), maxLength = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set = new HashSet<>();
            for(int j = i; j < n;j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                } else {
                    maxLength = Math.max(maxLength, j - i + 1);
                    set.add(s.charAt(j));
                }
            }
        }
        return maxLength;
    }
}