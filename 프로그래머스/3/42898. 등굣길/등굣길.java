class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        
        // 1차원 배열로 DP 구현
        int[] dp = new int[n+1];
        
        // 웅덩이 위치 기록 (좌표 변환에 주의)
        boolean[][] isPuddle = new boolean[m+1][n+1];
        for (int[] p : puddles) {
            isPuddle[p[0]][p[1]] = true;
        }
        
        // 시작점 초기화
        dp[1] = 1;
        
        // 각 행에 대해 DP 계산
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 시작점은 그대로 유지
                if (i == 1 && j == 1) continue;
                
                // 웅덩이면 해당 위치 값을 0으로
                if (isPuddle[i][j]) {
                    dp[j] = 0;
                } else {
                    // 현재 위치 = 왼쪽에서 오는 경우 + 위에서 오는 경우
                    // (단, j=1일 경우 왼쪽에서 오는 경우는 없음)
                    dp[j] = (dp[j] + (j > 1 ? dp[j-1] : 0)) % MOD;
                }
            }
        }
        
        return dp[n];
    }
}