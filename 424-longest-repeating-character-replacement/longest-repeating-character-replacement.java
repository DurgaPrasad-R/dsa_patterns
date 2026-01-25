class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, maxFreq = 0;
        int res = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char end = s.charAt(right);
            map.put(end, map.getOrDefault(end, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(end));

            while ((right - left + 1) - maxFreq > k) {
                char start = s.charAt(left);
                map.put(start, map.get(start) - 1);
                left+=1;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}