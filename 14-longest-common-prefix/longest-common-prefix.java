/**
 * This solution finds the longest common prefix among a set of strings
 * by leveraging lexicographical sorting.
 *
 * The algorithm first checks for the edge case where the input array
 * is empty. If so, an empty string is returned immediately.
 *
 * The array of strings is then sorted lexicographically.
 * After sorting, strings that share common prefixes will be positioned
 * close to each other in the array.
 *
 * To determine the longest common prefix for the entire array,
 * it is sufficient to compare only the first and the last strings
 * in the sorted order. Any prefix common to all strings must also
 * be common to these two.
 *
 * The algorithm iterates character by character, comparing the
 * corresponding characters of the first and last strings until
 * a mismatch is found or the end of one string is reached.
 *
 * The substring from the beginning up to the mismatch index
 * represents the longest common prefix and is returned as the result.
 *
 * Time Complexity:
 * - O(n log n + m), where n is the number of strings and
 *   m is the length of the longest common prefix.
 *
 * Space Complexity:
 * - O(1) extra space (excluding the output string),
 *   as the sorting is performed in place.
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;

        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }
}