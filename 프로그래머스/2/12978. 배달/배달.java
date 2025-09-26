import java.util.*;

class Solution {
    
    class Edge {
        int v, d;
        
        public Edge(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        List<Edge>[] edges = new List[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<Edge>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int d = r[2];
            
            edges[u].add(new Edge(v, d));
            edges[v].add(new Edge(u, d));
        }
        
        dijkstra(1, edges, dist, visited);
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }
        
        return count;
    }
    
    private void dijkstra(int start, List<Edge>[] edges, int[] dist, boolean[] visited) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (e1, e2) -> {
                return e1.d - e2.d;
            });
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            
            if (!visited[curr.v]) {
                visited[curr.v] = true;
            }
            
            for (Edge next : edges[curr.v]) {
                if (!visited[next.v] && dist[next.v] > curr.d + next.d) {
                    dist[next.v] = curr.d + next.d;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }
    }
}