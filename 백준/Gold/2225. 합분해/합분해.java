import java.io.*;
import java.util.*;

class Main {
    private static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        int[][] dp = new int[n + 1][k + 1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        System.out.print(dp[n][k] % MOD);
    }
}