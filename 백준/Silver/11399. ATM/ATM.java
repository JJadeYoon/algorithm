import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);
        int[] accum = new int[n];
        accum[0] = times[0];
        for (int i = 1; i < n; i++) {
            accum[i] = times[i] + accum[i - 1];
        }

        int total = Arrays.stream(accum).sum();
        System.out.print(total);
    }
}