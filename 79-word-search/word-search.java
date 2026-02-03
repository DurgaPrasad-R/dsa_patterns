class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (int r = 0 ; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                freqMap.put(board[r][c], freqMap.getOrDefault(board[r][c], 0) + 1);
            }
        }

        for (char ch : word.toCharArray()) {
            if (!freqMap.containsKey(ch) || freqMap.get(ch) <= 0) {
                return false;
            }
            freqMap.put(ch, freqMap.get(ch) - 1);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r, c, 0, board, word)) return true;
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, int idx, char[][] board, String word) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#' || board[r][c] != word.charAt(idx)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        boolean res = dfs(r - 1, c, idx + 1, board, word) || dfs(r + 1, c, idx + 1, board, word) || dfs(r, c + 1, idx + 1, board, word) || dfs(r, c - 1, idx + 1, board, word);
        board[r][c] = temp;
        return res;
    }
}