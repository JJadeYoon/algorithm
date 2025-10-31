class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(n, computers, i, visited);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int n, int[][] computers, int curr, boolean[] visited) {
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        for (int i = 0; i < n; i++) {
            if (computers[curr][i] == 1) {
                dfs(n, computers, i, visited);
            }
        }
    }
}