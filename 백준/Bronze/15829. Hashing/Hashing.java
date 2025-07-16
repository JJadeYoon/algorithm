import java.io.*;
import java.util.Arrays;

public class Main {

    private static final int R_VALUE = 31;
    private static final int M_VALUE = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        char[] target = br.readLine().toCharArray();

        long[] dp = new long[l];
        dp[0] = 1;
        for (int i = 1; i < l; i++) {
            dp[i] = dp[i - 1] * R_VALUE % M_VALUE;
        }

        long answer = 0;
        for (int i = 0; i < l; i++) {
            int intValue = (int) target[i] - (int) 'a' + 1;
            answer = (answer + intValue * dp[i] % M_VALUE) % M_VALUE;
        }
        System.out.print(answer);
    }
}