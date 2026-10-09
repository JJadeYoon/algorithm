import java.util.*;

class Solution {
    private final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    
    public int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        
        Queue<Integer> qx = new ArrayDeque<>();
        Queue<Integer> qy = new ArrayDeque<>();
        Queue<Integer> qd = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        
        qx.offer(0);
        qy.offer(0);
        qd.offer(1);
        
        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();
            int cd = qd.poll();
            
            if (cx == m - 1 && cy == n - 1) {
                return cd;
            }
            
            for (int[] dir : directions) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                
                if (nx >= 0 && ny >= 0 && nx < m && ny < n 
                    && !visited[nx][ny] && maps[nx][ny] == 1) {
                    qx.offer(nx);
                    qy.offer(ny);
                    qd.offer(cd + 1);
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}