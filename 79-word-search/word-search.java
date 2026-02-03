class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r, c, 0, board, word, new HashSet<>())) return true;
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, int idx, char[][] board, String word, Set<String> visited) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited.contains(r + "," + c) || board[r][c] != word.charAt(idx)) {
            return false;
        }

        visited.add(r + "," + c);
        boolean res = dfs(r - 1, c, idx + 1, board, word, visited) || dfs(r + 1, c, idx + 1, board, word,  visited) || dfs(r, c + 1, idx + 1, board, word, visited) || dfs(r, c - 1, idx + 1, board, word, visited);
        visited.remove(r + "," + c);
        return res;
    }
}