import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input);
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            bw.write(countRepeat(min, max) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int countRepeat(int min, int max) {
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isValid(int n) {
        int[] numbers = new int[10];
        while (n > 0) {
            numbers[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (numbers[i] > 1) {
                return false;
            }
        }
        return true;
    }
}