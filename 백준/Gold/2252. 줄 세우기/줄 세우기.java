import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        int[] degrees = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            degrees[v]++;
        }
        br.close();

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            path.add(curr);
            for (int nxt : edges[curr]) {
                degrees[nxt]--;
                if (degrees[nxt] == 0) {
                    queue.offer(nxt);
                }
            }
        }

        for (Integer i : path) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}