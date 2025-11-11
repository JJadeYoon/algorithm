class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            answer++;   
            dfs(i, visited, computers);
        }
        return answer;
    }
    
    private void dfs(int cur, boolean[] visited, int[][] computers) {
        visited[cur] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[cur][i] == 0 || cur == i) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            dfs(i, visited, computers);
        }
    }
}