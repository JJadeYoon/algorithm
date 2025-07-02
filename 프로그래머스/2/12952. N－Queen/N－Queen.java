class Solution {
    private int count = 0;

    public int solution(int n) {
        int[] board = new int[n];
        backtrack(0, n, board);
        return count;
    }

    private void backtrack(int row, int n, int[] board) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, board)) {
                board[row] = col;
                backtrack(row + 1, n, board);
            }
        }
    }

    private boolean isValid(int row, int col, int[] board) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col) {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(col - board[i])) {
                return false;
            }
        }
        return true;
    }
}