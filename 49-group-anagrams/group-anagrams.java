/**
 * This solution solves the Group Anagrams problem
 * using a pairwise comparison approach.
 *
 * A helper method `checkAnagrams` is used to determine
 * whether two strings are anagrams of each other.
 *
 * In `checkAnagrams`:
 * - The lengths of both strings are first compared.
 *   If they differ, the strings cannot be anagrams.
 * - A frequency map is built for characters in the
 *   first string.
 * - Characters from the second string are iterated,
 *   and their counts are reduced from the map.
 * - If any character is missing or overused,
 *   the strings are not anagrams.
 *
 * In `groupAnagrams`:
 * - A boolean array is used to track strings that
 *   have already been grouped.
 * - For each string, the algorithm compares it with
 *   all subsequent strings to find anagrams.
 * - All matching anagrams are grouped together
 *   and added to the result list.
 *
 * This ensures that each string is included in
 * exactly one group.
 *
 * Time Complexity:
 * - O(n² × k), where:
 *   n is the number of strings
 *   k is the average length of each string
 *   (due to repeated anagram checks).
 *
 * Space Complexity:
 * - O(n + k), due to the boolean array and
 *   the frequency map used during comparisons.
 */

class Solution {
    public boolean checkAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char c: s1.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for(char c: s2.toCharArray()) {
            if (!freq.containsKey(c) || freq.get(c) <= 0) {
                return false;
            }

            freq.put(c, freq.get(c) - 1);
        }

        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean[] foundAnagrams = new boolean[n];
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!foundAnagrams[i]) {
                List<String> currRes = new ArrayList<>();
                currRes.add(strs[i]);
                for (int j = i + 1; j < n; j++) {
                    if (checkAnagrams(strs[i], strs[j]) && !foundAnagrams[j]) {
                        currRes.add(strs[j]);
                        foundAnagrams[j] = true;
                    }
                }
                result.add(currRes);
            }
        }

        return result;
    }
}