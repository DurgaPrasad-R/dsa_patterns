class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> result = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }
        
        fillQueen(board, 0, result);
        return result;
    }

    public void fillQueen(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            List<String> res = new ArrayList<>();
            for (char[] arr : board) {
                res.add(new String(arr));
            }
            result.add(res);
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                fillQueen(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') return false;
        }

        for (int i = r, j = c; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = r, j = c; i>=0 && j < board[r].length; j++, i--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}