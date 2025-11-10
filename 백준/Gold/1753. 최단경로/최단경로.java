import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static class Edge {

        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        final int INF = Integer.MAX_VALUE / 2;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        List<Edge>[] edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Edge(v, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (e1, e2) -> {
                return e1.w - e2.w;
            }
        );

        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.w != dist[cur.v]) {
                continue;
            }
            for (Edge nxt : edges[cur.v]) {
                if (nxt.w + dist[cur.v] >= dist[nxt.v]) {
                    continue;
                }
                dist[nxt.v] = nxt.w + dist[cur.v];
                pq.offer(new Edge(nxt.v, dist[nxt.v]));
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                bw.write("INF");
            } else {
                bw.write(dist[i] + "");
            }
            if (i != n) {
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}