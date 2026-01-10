/**
 * Character Frequency Approach:
 *
 * The algorithm first validates that both strings have the same length,
 * since anagrams must contain the same number of characters.
 *
 * It then iterates through the first string and builds a frequency map
 * where each character is stored along with the number of times it appears.
 *
 * Next, the algorithm iterates through the second string and for each character:
 * - Verifies that the character exists in the map
 * - Ensures its frequency is greater than zero
 * - Decrements the frequency to mark usage
 *
 * If at any point a character is missing or overused, the strings
 * cannot be anagrams and the function returns false.
 *
 * If all characters are processed successfully, the strings are anagrams
 * and the function returns true.
 *
 * Time Complexity:
 * - O(n), where n is the length of the string
 *
 * Space Complexity:
 * - O(1) for fixed character sets (or O(n) in the worst case for large alphabets)
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> charMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch: t.toCharArray()) {
            if (!charMap.containsKey(ch) || charMap.get(ch) <= 0) {
                return false;
            }
            charMap.put(ch, charMap.get(ch) - 1);
        }

        return true;
    }
}