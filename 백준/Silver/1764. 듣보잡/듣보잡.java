import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] noListen = new String[n];
        String[] noWatch = new String[m];

        for (int i = 0; i < n; i++) {
            noListen[i] = br.readLine();
        }
        for (int i = 0; i < m; i++) {
            noWatch[i] = br.readLine();
        }
        Arrays.sort(noWatch);
        br.close();

        Set<String> set = new HashSet<>(Arrays.asList(noListen));
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(noWatch[i])) {
                count++;
                sb.append(noWatch[i]).append("\n");
            }
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }

        bw.write(count + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}