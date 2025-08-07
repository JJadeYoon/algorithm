import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> l = new HashSet<>();
        PriorityQueue<String> ls = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            l.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (l.contains(s)) {
                ls.offer(s);
            }
        }

        int size = ls.size();
        bw.write(size + "\n");
        for (int i = 0; i < size; i++) {
            bw.write(ls.poll());
            if (i < size - 1) {
                bw.write('\n');
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}