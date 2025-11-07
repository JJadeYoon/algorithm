import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        final int INF = Integer.MAX_VALUE / 2;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Edge>[] edges = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }
        int start = Integer.parseInt(br.readLine());
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Edge(v, w));
        }

        br.close();

        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (e1, e2) -> {
                return e1.w - e2.w;}
        );
        pq.offer(new Edge(start, dist[start]));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (dist[cur.v] != cur.w) {
                continue;
            }
            for (Edge nxt : edges[cur.v]) {
                if (dist[nxt.v] <= dist[cur.v] + nxt.w) {
                    continue;
                }
                dist[nxt.v] = dist[cur.v] + nxt.w;
                pq.offer(new Edge(nxt.v, dist[nxt.v]));
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}