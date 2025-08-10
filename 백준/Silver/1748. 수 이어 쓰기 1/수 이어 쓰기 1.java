import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 10) {
            System.out.print(n);
            return;
        }

        int m = 0;
        int temp = n;
        while (temp > 0) {
            temp /= 10;
            m++;
        }

        int answer = 0;
        int full = 9;
        for (int i = 1; i <= m; i++) {
            if (i == m) {
                answer += (int) ((n - Math.pow(10, m - 1) + 1) * i);
            } else {
                answer += full * i;
                full *= 10;
            }
        }

        System.out.print(answer);
    }
}