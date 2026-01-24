class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return s;

        int maxLen = 1, start = 0;
        boolean[][] dp = new boolean[n][n];
        
        // single characters are always palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // we'll check max. length of all palindromes with same length at once
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {
                // j is the end of new substring
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    // len of substring <= 3; it is always a palindrome
                    if (len <= 3 || dp[i+1][j-1]) {
                        dp[i][j] = true;

                        if (len > maxLen) {
                            maxLen = len;
                            start = i;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}