/**
 * The algorithm first sorts the array of strings based on their lengths
 * in ascending order. This ensures that the shortest string is processed first,
 * since the longest possible common prefix cannot exceed its length.
 *
 * The algorithm then iterates character by character over the shortest string.
 * For each character position `i`, it compares the character from the shortest
 * string with the character at the same position in all other strings.
 *
 * If a mismatch is found at any position, the comparison stops immediately,
 * as no further characters can be part of the common prefix.
 *
 * If all strings share the same character at a given position,
 * that character is appended to the result.
 *
 * This process continues until a mismatch occurs or the shortest
 * string is fully traversed.
 *
 * The accumulated characters form the longest common prefix,
 * which is returned as the final result.
 *
 * Time Complexity:
 * - O(n log n + m * n), where n is the number of strings and
 *   m is the length of the shortest string.
 *   (Sorting dominates for large n.)
 *
 * Space Complexity:
 * - O(1) extra space (excluding the output string),
 *   as no additional data structures proportional to input size are used.
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a,b) -> a.length() - b.length());
        
        int n = strs[0].length();
        int strsLen = strs.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = strs[0].charAt(i);
            boolean flag = true;
            for (int curr = 1; curr < strsLen; curr++) {
                if (strs[curr].charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
            else result.append(ch);
        }

        return result.toString();
    }
}