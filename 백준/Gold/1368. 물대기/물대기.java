import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static class Edge {

        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static int[] p;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        p = new int[n + 1];
        Arrays.fill(p, -1);

        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (e1, e2) -> {
                return e1.w - e2.w;
            }
        );

        for (int i = 1; i <= n; i++) {
            int w = Integer.parseInt(br.readLine());
            pq.offer(new Edge(0, i, w));
        }

        for (int i = 1; i <= n; i++) { // u
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) { // v
                int w = Integer.parseInt(st.nextToken());
                if (i >= j) { // (1,2), (1,3), (1,4)
                    continue;
                }
                pq.offer(new Edge(i, j, w));
            }
        }

        int cost = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (find(cur.u) != find(cur.v)) {
                union(cur.u, cur.v);
                cost += cur.w;
            }
        }

        System.out.print(cost);
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