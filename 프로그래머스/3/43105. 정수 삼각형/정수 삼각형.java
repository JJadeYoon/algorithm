class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j - 1] + triangle[i][j],
                            dp[i - 1][j] + triangle[i][j]
                    );
                }
            }
        }
        
        int answer = 0;
        for (int t : dp[len - 1]) {
            if (answer < t) {
                answer = t;
            }
        }

        return answer;
    }
}