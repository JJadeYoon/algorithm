import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point {
        int x;
        int y;
        int distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;

        boolean[][] visited = new boolean[m][n];

        int targetX = m - 1;
        int targetY = n - 1;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1));
        visited[0][0] = true;

        int[][] direction = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x == targetX && current.y == targetY) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {
                int x = current.x + direction[i][0];
                int y = current.y + direction[i][1];
                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && maps[x][y] == 1) {
                    queue.offer(new Point(x, y, current.distance + 1));
                    visited[x][y] = true;
                }
            }
        }

        return -1;
    }
}