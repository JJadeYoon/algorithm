import java.io.*;

public class Main {
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] board = new boolean[n][n];
        backtrack(n, 0, board);

        System.out.print(answer);
    }

    private static void backtrack(int n, int curRow, boolean[][] board) {
        if (n == curRow) {
            answer++;
            return;
        }

        for (int curCol = 0; curCol < n; curCol++) {
            if (!isValid(board, curRow, curCol)) {
                continue;
            }

            board[curRow][curCol] = true;
            backtrack(n, curRow + 1, board);
            board[curRow][curCol] = false;
        }
    }
    private static boolean isValid(boolean[][] board, int curRow, int curCol) {
        for (int preRow = 0; preRow < curRow; preRow++) {
            if (board[preRow][curCol]) {
                return false;
            }
            int left = curCol - (curRow - preRow);
            if (left >= 0 && board[preRow][left]) {
                return false;
            }
            int right = curCol + (curRow - preRow);
            if (right < board.length && board[preRow][right]) {
                return false;
            }
        }
        return true;
    }
}