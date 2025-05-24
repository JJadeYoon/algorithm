import java.util.*;

class Solution {
    static class Point {
        int x = 0;
        int y = 0;
        int distance = 0;
        
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
        visited[0][0] = true;
        
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1));
        
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (curr.x == m - 1 && curr.y == n - 1) {
                return curr.distance;
            }
            for (int[] d : directions) {
                int x = curr.x + d[0];
                int y = curr.y + d[1];
                if (x < m && x > -1 && y < n && y > -1 && !visited[x][y] && maps[x][y] == 1) {
                    queue.offer(new Point(x, y, curr.distance + 1));
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }
}