import java.util.*;

class Solution {
    
    int[][] directions = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] doubled = new int[rectangle.length][4];
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < 4; j++) {
                doubled[i][j] = rectangle[i][j] * 2;
            }
        }
        
        int startX = characterX * 2;
        int startY = characterY * 2;
        int endX = itemX * 2;
        int endY = itemY * 2;
        
        return bfs(doubled, startX, startY, endX, endY);
    }
    
    private boolean isOnBorder(int x, int y, int[][] rectangle) {
        boolean onEdge = false;
        
        for (int[] rect : rectangle) {
            int x1 = rect[0], y1 = rect[1];
            int x2 = rect[2], y2 = rect[3];
            
            if (x > x1 && x < x2 && y > y1 && y < y2) {
                return false;
            }
            
            if ((x == x1 || x == x2) && y >= y1 && y <= y2) {
                onEdge = true;
            }
            if ((y == y1 || y == y2) && x >= x1 && x <= x2) {
                onEdge = true;
            }
        }
        
        return onEdge;
    }
    
    private int bfs(int[][] rectangle, int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            
            if (x == endX && y == endY) {
                return dist / 2;
            }
            
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx < 0 || nx > 100 || ny < 0 || ny > 100) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (isOnBorder(nx, ny, rectangle)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        
        return -1;
    }
}