import java.io.*;
import java.util.*;

class Main {
    private static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static class UnionFind {
        int[] p;

        UnionFind(int n) {
            p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = -1;
            }
        }

        int find(int x) {
            if (p[x] < 0) {
                return x;
            }
            return p[x] = find(p[x]);
        }

        boolean union(int u, int v) {
            u = find(u);
            v = find(v);

            if (u == v) {
                return false;
            }

            if (p[v] < p[u]) {
                p[u] = v;
            } else if (p[u] < p[v]) {
                p[v] = u;
            } else {
                p[v] = u;
                p[u]--;
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        System.out.print(kruskal(n, edges));
    }

    private static int kruskal(int n, List<Edge> edges) {
        Collections.sort(edges, (e1, e2) -> e1.w - e2.w);
        UnionFind uf = new UnionFind(n);

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                mst.add(edge);
                totalWeight += edge.w;
            }

            if (mst.size() == n - 1) {
                break;
            }
        }

        if (mst.size() == n - 1) {
            return totalWeight;
        } else {
            return -1;
        }
    }
}