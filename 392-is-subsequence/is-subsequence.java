class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) return true;
        else if (n == 0) return false;
        
        int s1 = 0, t1 = 0;
        while (t1 < n) {
            if (s.charAt(s1) == t.charAt(t1)) {
                if (s1 == m - 1) return true;
                s1 += 1;
            }
            t1 += 1;
        }

        return false;
    }
}