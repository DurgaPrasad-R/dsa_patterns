/**
 * This approach solves the Longest Substring Without Repeating Characters
 * problem using an improved brute-force technique.
 *
 * The algorithm fixes a starting index and expands the substring one
 * character at a time using a second loop.
 *
 * A HashSet is used to keep track of characters present in the current
 * substring. As characters are added, we check for duplicates.
 *
 * If a duplicate character is encountered, the expansion stops immediately
 * for that starting index, since any further extension would also be invalid.
 *
 * Difference from Naive Brute Force:
 * - In the naive brute-force approach, all possible substrings are generated
 *   and a third loop is used to re-check each substring for character uniqueness.
 * - In this approach, uniqueness is verified incrementally while expanding
 *   the substring, eliminating the need for a separate validation loop.
 * - By detecting duplicates early and stopping expansion immediately, we
 *   avoid redundant checks performed by the third loop.
 *
 * Time Complexity:
 * - O(n²), since for each starting index, the substring may be expanded
 *   up to the end of the string.
 *
 * Space Complexity:
 * - O(min(n, k)), where k is the size of the character set, due to the
 *   HashSet used to store characters of the current substring.
 */

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