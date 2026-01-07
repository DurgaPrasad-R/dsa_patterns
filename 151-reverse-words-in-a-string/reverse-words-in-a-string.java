/**
 * This solution reverses the order of words in a given string
 * while removing extra spaces.
 *
 * The algorithm iterates through the string character by character
 * and constructs each word using a StringBuilder.
 *
 * When a space character is encountered, the currently formed word
 * (if non-empty) is added to a list of words, and the word builder
 * is reset. This ensures that multiple consecutive spaces are ignored.
 *
 * After the iteration completes, the last word is added to the list
 * if it exists.
 *
 * Once all valid words are collected, the list is traversed in
 * reverse order to build the final result string, inserting a
 * single space between words.
 *
 * Using a list to store words and StringBuilder for string construction
 * avoids repeated string concatenation and improves performance.
 *
 * Time Complexity:
 * - O(n), where n is the length of the input string, since each
 *   character is processed once.
 *
 * Space Complexity:
 * - O(n), due to additional space used to store the words and
 *   construct the output string.
 */

class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (char ch: s.toCharArray()) {
            if (ch != ' ') {
                word.append(ch);
            } else if (word.length() > 0) {
                words.add(word.toString());
                word.setLength(0);
            }
        }

        if (word.length() > 0) {
            words.add(word.toString());
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            result.append(words.get(i));
            if (i > 0) result.append(" ");
        }
        
        return result.toString();
    }
}