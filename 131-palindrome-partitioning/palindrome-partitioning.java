class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0 ; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 3 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        backtrack(s, 0, dp, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(String s, int start, boolean[][] dp, List<String> path, List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }


        for (int end = start + 1; end <= s.length(); end++) {
            if (dp[start][end - 1]) {
                path.add(s.substring(start, end));
                backtrack(s, end, dp, path, result);
                path.remove(path.size() - 1);
            }
        }

    }
}