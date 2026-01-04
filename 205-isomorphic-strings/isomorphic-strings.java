/* Two HashMaps are used to maintain character mappings:
 * - mapST for s -> t
 * - mapTS for t -> s
 *
 * The algorithm iterates through both strings simultaneously:
 * - If a character in s is already mapped, its mapped value
 *   must match the corresponding character in t.
 * - Similarly, if a character in t is already mapped, it
 *   must map to the character in s.
 * - If any mapping conflicts occur, the strings are not isomorphic.
 *
 * Time Complexity:
 * - O(n), as we iterate through the strings once.
 *
 * Space Complexity:
 * - O(n), for the two HashMaps storing character mappings.
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (mapST.containsKey(s.charAt(i))) {
                if (mapST.get(s.charAt(i)) != t.charAt(i)) return false;
            }

            if (mapTS.containsKey(t.charAt(i))) {
                if (mapTS.get(t.charAt(i)) != s.charAt(i)) return false;
            }

            mapST.put(s.charAt(i), t.charAt(i));
            mapTS.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}