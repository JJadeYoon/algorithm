import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        List<Integer> current = new ArrayList<>();
        backtrack(visited, n, m, current);

        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtrack(boolean[] visited, int n, int m, List<Integer> current) {
        if (current.size() == m) {
            for (int i = 0; i < current.size(); i++) {
                sb.append(current.get(i));
                if (i < current.size() - 1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(i);

                backtrack(visited, n, m, current);

                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}