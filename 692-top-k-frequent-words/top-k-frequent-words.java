class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return b.compareTo(a);
            }
            return freq.get(a) - freq.get(b);
        });

        for (String ele : freq.keySet()) {
            pq.offer(ele);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        
        while (!pq.isEmpty()) {
            String ele = pq.poll();
            result.add(0, ele);
        }
        return result;
    }
}