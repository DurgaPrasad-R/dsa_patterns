class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), maxLength = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();

        while (left <= right && right < n) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left += 1;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
                set.add(s.charAt(right));
                right += 1;
            }
        }

        return maxLength;
    }
}