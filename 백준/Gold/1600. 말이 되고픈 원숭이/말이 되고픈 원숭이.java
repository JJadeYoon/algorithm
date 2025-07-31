import java.io.*;
import java.util.*;

public class Main {

    private static int MAX_HORSE_MOVE;

    private static final int[][] HORSE_DIR = {
            {1, 2}, {2, 1},
            {1, -2}, {-2, 1},
            {-1, 2}, {2, -1},
            {-1, -2}, {-2, -1}
    };

    private static final int[][] MONKEY_DIR = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private static class Node {
        int row, col, dist;
        int horseMove;

        Node(int row, int col, int dist, int horseMove) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.horseMove = horseMove;
        }
    }

    private static boolean isValid(int row, int col, int horseMove, int[][] map, boolean[][][] visited) {
        int n = visited.length;
        int m = visited[0].length;
        int t = visited[0][0].length;
        if (row < 0 || col < 0 || row >= n || col >= m || horseMove >= t) {
            return false;
        }
        return map[row][col] == 0 && !visited[row][col][horseMove];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MAX_HORSE_MOVE = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        boolean[][][] visited = new boolean[n][m][MAX_HORSE_MOVE + 1];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            if (currRow == n - 1 && currCol == m - 1) {
                System.out.print(curr.dist);
                return;
            }

            for (int i = 0; i < MONKEY_DIR.length + HORSE_DIR.length; i++) {
                int[] dir;
                int nextHorseMove = curr.horseMove;
                int nextDist = curr.dist + 1;
                if (i >= MONKEY_DIR.length) {
                    if (curr.horseMove <= MAX_HORSE_MOVE) {
                        dir = HORSE_DIR[i - MONKEY_DIR.length];
                        nextHorseMove++;
                    } else {
                        continue;
                    }
                } else {
                    dir = MONKEY_DIR[i];
                }

                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (isValid(nextRow, nextCol, nextHorseMove, map, visited)) {
                    visited[nextRow][nextCol][nextHorseMove] = true;
                    queue.offer(new Node(nextRow, nextCol, nextDist, nextHorseMove));
                }
            }
        }

        System.out.print(-1);
    }
}