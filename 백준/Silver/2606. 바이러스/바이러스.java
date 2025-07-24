import java.io.*;
import java.util.*;

public class Main {
    private static final int START = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        int m = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(START);
        visited[START] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (!visited[curr]) {
                visited[curr] = true;
            }

            for (int next : graph[curr]) {
                if (!visited[next]) {
                    queue.offer(next);
                }
            }
        }
        visited[START] = false;

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.print(count);
    }
}