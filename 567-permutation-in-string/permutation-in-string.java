class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;
        
        Map<Character, Integer> s1Freq = new HashMap<>();
        Map<Character, Integer> s2Freq = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            char ch = s1.charAt(i);
            s1Freq.put(ch, s1Freq.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < n1 - 1; i++) {
            char ch = s2.charAt(i);
            s2Freq.put(ch, s2Freq.getOrDefault(ch, 0) + 1);
        }

        for (int i = n1 - 1; i < n2; i++) {
            char right = s2.charAt(i);
            s2Freq.put(right, s2Freq.getOrDefault(right, 0) + 1);

            if (s1Freq.equals(s2Freq)) {
                return true;
            }

            char left = s2.charAt(i - n1 + 1);
            s2Freq.put(left, s2Freq.get(left) - 1);
            
            if (s2Freq.get(left) == 0) {
                s2Freq.remove(left);
            }
        }
        return false;
    }
}