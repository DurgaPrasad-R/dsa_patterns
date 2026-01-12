/**
 * Sliding Window approach:
 * Two frequency arrays are maintained:
 * - `pFreq` stores the character frequency of string `p`
 * - `sFreq` stores the character frequency of the current window in `s`
 *
 * The window is expanded by moving the `right` pointer and including
 * the current character in `sFreq`.
 *
 * If the window size exceeds the length of `p`, the window is shrunk
 * from the left by removing the leftmost character from `sFreq`
 * and moving the `left` pointer forward.
 *
 * Once the window size exactly matches the length of `p`,
 * the two frequency arrays are compared.
 * If they are equal, it indicates the current window is an anagram
 * of `p`, and the starting index (`left`) is added to the result list.
 *
 * This process continues until the entire string `s` is traversed.
 *
 * Time Complexity:
 * - O(n), where n is the length of string `s`.
 *   Frequency comparison takes constant time since the alphabet size is fixed.
 *
 * Space Complexity:
 * - O(1), as fixed-size frequency arrays of length 26 are used.
 */

class Solution {
    public boolean isValid (int[] pFreq, int[] sFreq) {
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] != sFreq[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int n = s.length(), m = p.length();
        int left = 0;

        int[] sFreq = new int[26];
        int[] pFreq = new int[26];

        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a'] += 1;
        }

        for (int right = 0; right < n; right++) {
            sFreq[s.charAt(right) - 'a'] += 1;
            
            if (right - left + 1 > m) {
                sFreq[s.charAt(left) - 'a'] -= 1;
                left += 1;
            }

            if (right - left + 1 == m) {
                if (isValid(pFreq, sFreq)) {
                    result.add(left);
                }
            }
        }
        return result;
    }
}