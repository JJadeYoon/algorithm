import java.util.*;

class Solution {
    
    class Edge {
        int v, w;
        
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    
    public int solution(int N, int[][] roads, int K) {
        List<Edge>[] edges = new List[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int[] r : roads) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            
            edges[u].add(new Edge(v, w));
            edges[v].add(new Edge(u, w));
        }
        
        dijkstra(edges, visited, dist, 1);
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dijkstra(List<Edge>[] edges, boolean[] visited, int[] dist, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (e1, e2) -> { return e1.w - e2.w; }
        );
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (!visited[curr.v]) {
                visited[curr.v] = true;
            }
            
            for (Edge next : edges[curr.v]) {
                if (!visited[next.v] && curr.w + next.w < dist[next.v]) {
                    dist[next.v] = curr.w + next.w;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }
    }
}