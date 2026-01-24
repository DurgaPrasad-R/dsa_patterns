class Solution {
    public static int expandAroundCenter(String s, int l, int r) {
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l -= 1;
            r += 1;
        }

        return r - l - 1;
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);
            int len = Math.max(odd, even);

            if (len > end - start) {
                start = i - (len - 1)/ 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }
}