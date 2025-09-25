import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < computers.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            count++;
            dfs(computers, visited, i, n);
        }
        
        return count;
    }
    
    public void dfs(int[][] computers, boolean[] visited, int curr, int n) {
        int[] conn = computers[curr];
        for (int i = 0; i < n; i++) {
            if (conn[i] == 1 && i != curr) {
                if (visited[i]) {
                    continue;
                }

                visited[i] = true;
                dfs(computers, visited, i, n);
            }
        }
    }
}