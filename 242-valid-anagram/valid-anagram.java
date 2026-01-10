/**
 * This solution checks whether two strings are anagrams of each other
 * by comparing the frequency of each character.
 *
 * Since the strings consist only of lowercase English letters,
 * a fixed-size integer array of length 26 is used to track
 * character frequencies efficiently.
 *
 * The algorithm first iterates through the first string `s`
 * and increments the count corresponding to each character.
 *
 * It then iterates through the second string `t`
 * and decrements the count for each character encountered.
 *
 * If the two strings are true anagrams, all character counts
 * will balance out and result in zero.
 *
 * Finally, the frequency array is checked to ensure that
 * no character count is negative, which would indicate
 * a mismatch in character occurrences.
 *
 * An early length check is performed to quickly eliminate
 * strings that cannot be anagrams.
 *
 * Time Complexity:
 * - O(n), where n is the length of the strings.
 *
 * Space Complexity:
 * - O(1), because a fixed-size array of 26 elements is used.
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] chars = new int[26];
        for (char ch : s.toCharArray()) {
            chars[ch-'a'] = chars[ch-'a'] + 1;
        }

        for (char ch: t.toCharArray()) {
            chars[ch-'a'] = chars[ch-'a'] - 1;
        }
        for (int i = 0; i< 26; i++) {
            if (chars[i] != 0) return false;
        }
        return true;
    }
}