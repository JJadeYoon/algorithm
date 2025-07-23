import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int count = dp[i - 1] + 1;
            if (i % 3 == 0) {
                count = Math.min(dp[i / 3] + 1, count);
            }
            if (i % 2 == 0) {
                count = Math.min(dp[i / 2] + 1, count);
            }
            dp[i] = count;
        }

        System.out.print(dp[n]);
    }
}