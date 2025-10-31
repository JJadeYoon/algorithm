class Solution {
    
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n + 1][n + 1];
        for (int[] result : results) {
            int w = result[0] - 1;
            int l = result[1] - 1;
            win[w][l] = true;
        }
        
        for (int k = 0; k < n; k++) { // 거쳐가는 노드
            for (int i = 0; i < n; i++) {
                if (!win[i][k]) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int wins = 0;
            int losses = 0;
            for (int j = 0; j < n; j++) {
                if (win[i][j]) {
                    wins++;
                }
                if (win[j][i]) {
                    losses++;
                }
            }
            if (wins + losses == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}