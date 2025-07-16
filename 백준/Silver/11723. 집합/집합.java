import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int m = Integer.parseInt(br.readLine());
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    s.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    s.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    if (s.contains(Integer.parseInt(st.nextToken()))) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    int value = Integer.parseInt(st.nextToken());
                    if (!s.remove(value)) {
                        s.add(value);
                    }
                    break;
                case "all":
                    s.clear();
                    for (int j = 1; j <= 20; j++) {
                        s.add(j);
                    }
                    break;
                case "empty":
                    s.clear();
                    break;
                default:
                    break;

            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}