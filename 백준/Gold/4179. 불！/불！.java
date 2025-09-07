import java.io.*;
import java.util.*;

class Main {

    private static class Point {
        int row, col, time;

        public Point(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    private static final int[][] directions = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            maze[i] = br.readLine().toCharArray();
        }


        Point start = null;
        Queue<Point> fireQueue = new ArrayDeque<>();
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 'J') {
                    start = new Point(i, j, 0);
                }
                if (maze[i][j] == 'F') {
                    fireQueue.offer(new Point(i, j, 0));
                }
            }
        }

        int[][] fireTime = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(fireTime[i], Integer.MAX_VALUE);
        }
        while (!fireQueue.isEmpty()) {
            Point fire = fireQueue.poll();
            if (fireTime[fire.row][fire.col] <= fire.time) {
                continue;
            }

            fireTime[fire.row][fire.col] = fire.time;

            for (int[] dir : directions) {
                int nextRow = fire.row + dir[0];
                int nextCol = fire.col + dir[1];

                if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) {
                    continue;
                }

                if (maze[nextRow][nextCol] == '#' || fireTime[nextRow][nextCol] <= fire.time + 1) {
                    continue;
                }

                fireQueue.offer(new Point(nextRow, nextCol, fire.time + 1));
            }

        }

        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(start);
        visited[start.row][start.col] = true;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int[] dir : directions) {
                int nextRow = curr.row + dir[0];
                int nextCol = curr.col + dir[1];
                int nextTime = curr.time + 1;

                if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) {
                    System.out.print(nextTime);
                    return;
                }

                if (visited[nextRow][nextCol] || maze[nextRow][nextCol] == '#') {
                    continue;
                }

                if (fireTime[nextRow][nextCol] <= nextTime) {
                    continue;
                }

                visited[nextRow][nextCol] = true;
                queue.offer(new Point(nextRow, nextCol, nextTime));
            }
        }

        System.out.print("IMPOSSIBLE");
    }
}