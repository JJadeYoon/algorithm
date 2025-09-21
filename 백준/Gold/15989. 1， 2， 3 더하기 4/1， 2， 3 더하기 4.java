import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] numbers = new int[t];
        int maxNum = 0;
        for (int i = 0; i < t; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            maxNum = Math.max(maxNum, numbers[i]);
        }
        br.close();

        int[][] dp = new int[maxNum + 3][4];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 0;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= maxNum; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
        for (int i = 0; i < t; i++) {
            int sum = 0;
            for (int j = 1; j <= 3; j++) {
                sum += dp[numbers[i]][j];
            }
            bw.write(sum + "");
            if (i != t - 1) {
                bw.write('\n');
            }
        }
        bw.close();
    }
}