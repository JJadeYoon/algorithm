import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int remain = 1000 - Integer.parseInt(br.readLine());
        int[] money = {500, 100, 50, 10, 5, 1};

        int idx = 0;
        int count = 0;
        while (remain > 0) {
            if (remain >= money[idx]) {
                remain -= money[idx];
                count++;
            } else {
                idx++;
            }
        }

        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}