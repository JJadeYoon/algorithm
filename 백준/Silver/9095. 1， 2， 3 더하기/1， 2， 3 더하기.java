import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX_N = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[MAX_N + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= MAX_N; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i] += dp[i - j];
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "");
            if (i < t - 1) {
                bw.write("\n");
            }
        }
        bw.flush();
    }
}