import java.util.*;

class Solution {
    private static class Edge {
        int v;
        int weight;
        
        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }
    
    private List<Edge>[] graph;
    private int[] dist;
    private boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {
        graph = new List[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int[] r : road) {
            int inputU = r[0];
            int inputV = r[1];
            int inputW = r[2];
            
            graph[inputU].add(new Edge(inputV, inputW));
            graph[inputV].add(new Edge(inputU, inputW));
        }
        
        dijkstra(1);
        
        int answer = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
    
    private void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (o1, o2) -> o1.weight - o2.weight
        );
        
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            
            if (!visited[curr.v]) {
                visited[curr.v] = true;
            }
            
            for (Edge next : graph[curr.v]) {
                if (!visited[next.v] && dist[next.v] > curr.weight + next.weight) {
                    dist[next.v] = curr.weight + next.weight;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }
    }
}