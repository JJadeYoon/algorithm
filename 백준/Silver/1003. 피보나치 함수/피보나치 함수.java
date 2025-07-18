import java.io.*;

public class Main {
    private static final int MAX_N = 40;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] countZero = new int[MAX_N + 1];
        int[] countOne = new int[MAX_N + 1];

        countZero[0] = 1;
        countZero[1] = 0;

        countOne[0] = 0;
        countOne[1] = 1;

        for (int i = 2; i <= MAX_N; i++) {
            countZero[i] = countZero[i - 2] + countZero[i - 1];
            countOne[i] = countOne[i - 2] + countOne[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(countZero[num]).append(" ").append(countOne[num]).append("\n");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }

        System.out.print(sb.toString());
    }
}