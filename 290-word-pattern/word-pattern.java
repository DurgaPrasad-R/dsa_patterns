class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        int n = pattern.length();
        int m = strs.length;

        if (n != m) return false;

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            if (map1.containsKey(ch)) {
                String val = map1.get(ch);
                if (!val.equals(strs[i])) return false;
            } else if (map2.containsKey(strs[i])) {
                Character ch1 = map2.get(strs[i]);
                if (ch != ch1) return false;
            }
            map1.put(ch, strs[i]);
            map2.put(strs[i], ch);
        }

        return true;
    }
}