/**
 * Sliding Window (Two Pointers) technique:
 * Two pointers, `left` and `right`, are used to represent
 * a moving window over the string `s`.
 *
 * A frequency map `need` stores the count of each character
 * required from string `t`.
 *
 * The variable `required` tracks how many characters
 * (including duplicates) are still needed to form a valid window.
 *
 * The window is expanded by moving the `right` pointer.
 * When a required character is encountered, its count in
 * the map is reduced and `required` is decremented.
 *
 * Once all required characters are present (`required == 0`),
 * the window is valid. The algorithm then tries to shrink
 * the window from the left to minimize its size while
 * keeping it valid.
 *
 * The smallest valid window found during this process
 * is stored using start index and length.
 *
 * Time Complexity:
 * - O(n), since each character is processed at most twice.
 *
 * Space Complexity:
 * - O(k), where k is the number of distinct characters in `t`.
 */

class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int n = s.length(), required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        while (right < n) {
            char ch = s.charAt(right);

            if (need.containsKey(ch)) {
                if (need.get(ch) > 0) {
                    required -= 1;
                }
                need.put(ch, need.get(ch) - 1);
            }

            while (required == 0) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    need.put(leftChar, need.get(leftChar) + 1);
                    if (need.get(leftChar) > 0) {
                        required += 1;
                    }
                }
                left += 1;
            }
            right += 1;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}