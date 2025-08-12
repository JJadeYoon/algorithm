import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static final int PAPER_SIZE = 10;
    private static final int MAX_SIZE = 5;
    private static final int PAPER_AMOUNT = 5;

    private static int minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] paper = new int[PAPER_SIZE][PAPER_SIZE];

        StringTokenizer st;
        for (int i = 0; i < PAPER_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < PAPER_SIZE; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] nextOne = findNextOne(paper, 0, 0);
        if (nextOne[0] == -1 && nextOne[1] == -1) {
            System.out.print(0);
            return;
        }

        int[] remains = new int[MAX_SIZE + 1];
        for (int i = 1; i <= MAX_SIZE; i++) {
            remains[i] = PAPER_AMOUNT;
        }

        backtrack(paper, remains, 0, 0, 0);

        if (minCnt == Integer.MAX_VALUE) {
            minCnt = -1;
        }

        System.out.print(minCnt);
    }

    private static int[] findNextOne(int[][] paper, int row, int col) {
        for (int i = row; i < PAPER_SIZE; i++) {
            int j = i == row ? col : 0;
            for (; j < PAPER_SIZE; j++) {
                if (paper[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static void backtrack(int[][] p, int[] remains, int row, int col, int cnt) {
        int[] nextOne = findNextOne(p, row, col);
        row = nextOne[0];
        col = nextOne[1];

        if (row == -1 && col == -1) {
            minCnt = Math.min(Main.minCnt, cnt);
            return;
        }

        for (int size = MAX_SIZE; size >= 1; size--) {
            if (remains[size] < 1) {
                continue;
            }

            if (cnt + 1 >= minCnt) {
                continue;
            }

            if ((row + size <= PAPER_SIZE && col + size <= PAPER_SIZE) && isPaperFit(p, row, col, size)) {
                attach(p, row, col, size);
                remains[size]--;

                backtrack(p, remains, row, col, cnt + 1);

                detach(p, row, col, size);
                remains[size]++;
            }
        }
    }

    private static boolean isPaperFit(int[][] p, int row, int col, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (p[row + i][col + j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void attach(int[][] p, int row, int col, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                p[row + i][col + j] = 0;
            }
        }
    }

    private static void detach(int[][] p, int row, int col, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                p[row + i][col + j] = 1;
            }
        }
    }
}