class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;

        boolean[][] puddleMap = new boolean[m+1][n+1];
        for (int[] p : puddles) {
            puddleMap[p[0]][p[1]] = true;
        }

        int[] dp = new int[n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[j] = 1;
                    continue;
                }
                // 웅덩이인지 확인
                if (puddleMap[i][j]) {
                    dp[j] = 0;
                    continue;
                }
                dp[j] = (dp[j] + dp[j-1]) % MOD;
            }
        }
        return dp[n];
    }
}