import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static class Point {
        int x, y, count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {
                {1, 0}, {0, 1}, {0, -1}, {-1, 0}
        };

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[0][0] = true;
        Deque<Point> deque = new ArrayDeque<>();
        deque.offer(new Point(0, 0, 0));

        int answer = m * n;

        while (!deque.isEmpty()) {
            Point point = deque.pollFirst();
            if (point.x == n - 1 && point.y == m - 1) {
                answer = Math.min(answer, point.count);
            }
            for (int[] d : directions) {
                int nextX = point.x + d[0];
                int nextY = point.y + d[1];
                int count = point.count;

                if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    if (map[nextX][nextY] == '1') {
                        deque.offerLast(new Point(nextX, nextY, count + 1));
                    } else {
                        deque.offerFirst(new Point(nextX, nextY, count));
                    }
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}