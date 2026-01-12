class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (freq[ch - 'a'] == 0) return false;
            freq[ch - 'a'] -= 1;
        }

        return true;
    }
}