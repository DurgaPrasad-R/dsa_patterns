/**
 * This solution checks whether two strings are anagrams
 * by comparing their sorted character sequences.
 *
 * An anagram requires both strings to:
 * - Have the same length
 * - Contain the same characters with the same frequencies
 *
 * The algorithm first checks if the lengths of the two strings
 * are equal. If not, they cannot be anagrams and the method
 * immediately returns false.
 *
 * Both strings are then converted into character arrays.
 * These arrays are sorted so that identical characters
 * appear in the same order.
 *
 * After sorting, the algorithm compares the characters
 * at each index of both arrays.
 * - If any pair of characters differs, the strings are
 *   not anagrams.
 * - If all characters match, the strings are anagrams.
 *
 * Time Complexity:
 * - O(n log n), where n is the length of the strings,
 *   due to sorting both character arrays.
 *
 * Space Complexity:
 * - O(n), since additional character arrays are created.
 */
 
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int n = s.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for(int i = 0; i < n; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }
}