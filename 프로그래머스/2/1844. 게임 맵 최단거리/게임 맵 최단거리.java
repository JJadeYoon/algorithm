import java.util.*;

class Solution {
    
    private static final int[][] directions = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<Integer> xQ = new ArrayDeque<>();
        Queue<Integer> yQ = new ArrayDeque<>();
        Queue<Integer> tQ = new ArrayDeque<>();
        
        xQ.offer(0);
        yQ.offer(0);
        tQ.offer(1);
        visited[0][0] = true;
        
        while (!xQ.isEmpty()) {
            int currX = xQ.poll();
            int currY = yQ.poll();
            int currT = tQ.poll();
            
            if (currX == n - 1 && currY == m - 1) {
                return currT;
            }
            
            for (int[] dir : directions) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                
                if (isValid(maps, visited, nextX, nextY)) {
                    xQ.offer(nextX);
                    yQ.offer(nextY);
                    tQ.offer(currT + 1);
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValid(int[][] maps, boolean[][] visited, int x, int y) {
        int n = maps.length;
        int m = maps[0].length;
        
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        if (maps[x][y] == 0) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        
        return true;
    }
}