class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = triangle[i][j];
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        int answer = 0;
        int[] lastDP = dp[dp.length - 1];
        for (int i = 0; i < lastDP.length; i++) {
            answer = Math.max(answer, lastDP[i]);
        }
        
        return answer;
    }
}