import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int prev = 1;
        int numLen = 1;

        while (prev <= n) {
            if (prev * 10 > n) {
                cnt += (n - prev + 1) * numLen;
            } else {
                cnt += numLen * (prev * 10 - prev);
            }
            prev *= 10;
            numLen++;
        }

        System.out.print(cnt);
    }
}