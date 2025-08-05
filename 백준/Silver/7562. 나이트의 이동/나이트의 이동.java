import java.io.*;
import java.util.*;

public class Main {
    private static final int[][] directions = {
            {2, 1}, {1, 2}, {2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {-2, -1}, {-1, -2}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = new int[2];
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] target = new int[2];
            target[0] = Integer.parseInt(st.nextToken());
            target[1] = Integer.parseInt(st.nextToken());

            bw.write(countMove(new boolean[l][l], start, target) + "");
            if (i != t - 1) {
                bw.write('\n');
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int countMove(boolean[][] map, int[] start, int[] target) {
        int move = 0;

        Queue<Integer> rowQueue = new ArrayDeque<>();
        Queue<Integer> colQueue = new ArrayDeque<>();
        Queue<Integer> moveQueue = new ArrayDeque<>();
        rowQueue.offer(start[0]);
        colQueue.offer(start[1]);
        moveQueue.offer(move);
        map[start[0]][start[1]] = true;

        while (!rowQueue.isEmpty()) {
            int currRow = rowQueue.poll();
            int currCol = colQueue.poll();
            int currMove = moveQueue.poll();

            if (currRow == target[0] && currCol == target[1]) {
                return currMove;
            }

            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < map.length && nextCol < map.length) {
                    if (!map[nextRow][nextCol]) {
                        map[nextRow][nextCol] = true;
                        rowQueue.offer(nextRow);
                        colQueue.offer(nextCol);
                        moveQueue.offer(currMove + 1);
                    }
                }
            }
        }

        return move;
    }
}