class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> anagramList = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String temp = String.valueOf(charArr);
            
            if (!anagramList.containsKey(temp)) {
                anagramList.put(temp, new ArrayList<String>());
            }

            List<String> res = anagramList.get(temp);
            res.add(strs[i]);
            anagramList.put(temp, res);

        }
        
        for (List<String> res: anagramList.values()) {
            result.add(res);
        }
        return result;
    }
}