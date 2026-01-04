/**
 * This solution solves the Group Anagrams problem using
 * hashing with a canonical representation.
 *
 * The core idea is that all anagrams share the same
 * sorted character sequence.
 *
 * For each string in the input array:
 * - Convert the string to a character array
 * - Sort the character array
 * - Convert it back to a string to form a unique key
 *
 * This sorted string acts as the "anagram signature".
 * All strings with the same signature are grouped together
 * in a HashMap.
 *
 * The HashMap maps:
 * - Key   -> sorted string (anagram signature)
 * - Value -> list of original strings that are anagrams
 *
 * The method uses `computeIfAbsent` to initialize a list
 * for a key only when it does not already exist, keeping
 * the code concise and readable.
 *
 * Finally, all the grouped anagram lists are collected
 * from the map and returned as the result.
 *
 * Time Complexity:
 * - O(n * k log k), where:
 *   n = number of strings
 *   k = maximum length of a string
 *   Each string is sorted before insertion.
 *
 * Space Complexity:
 * - O(n * k), due to storing sorted keys and grouped strings
 *   in the HashMap.
 *
 * This approach is the preferred interview solution as it
 * avoids pairwise comparisons and scales efficiently.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> anagramList = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            
            anagramList.computeIfAbsent(key, k -> new ArrayList<>())
               .add(str);


        }
        
        return new ArrayList<>(anagramList.values());
    }
}