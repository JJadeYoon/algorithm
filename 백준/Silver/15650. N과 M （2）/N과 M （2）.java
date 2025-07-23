import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        List<Integer> curr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(visited, m, sb, curr, 0);

        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        System.out.print(sb.toString());
    }

    private static void backtrack(boolean[] visited, int m, StringBuilder sb, List<Integer> curr, int prev) {
        if (curr.size() == m) {
            for (int i = 0; i < m; i++) {
                sb.append(curr.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] || prev > i) {
                continue;
            }

            visited[i] = true;
            curr.add(i);

            backtrack(visited, m, sb, curr, i);

            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}