import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static int[] p;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        p = new int[V + 1];
        Arrays.fill(p, -1);

        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (e1, e2) -> {
                return e1.w - e2.w;}
        );

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(u, v, w));
        }

        int total = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (find(e.u) != find(e.v)) {
                total += e.w;
                union(e.u, e.v);
            }
        }

        System.out.print(total);
    }

    private static int find(int u) {
        if (p[u] < 0) {
            return u;
        }
        return p[u] = find(p[u]);
    }

    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return false;
        }
        p[v] = u;
        return true;
    }
}