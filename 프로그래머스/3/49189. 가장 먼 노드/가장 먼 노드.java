import java.util.*;

class Solution {
    
    class Edge {
        int from, to;
        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    
    public int solution(int n, int[][] edge) {
        List<Edge>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];
            edges[from].add(new Edge(from, to));
            edges[to].add(new Edge(to, from));
        }
        
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        Queue<int[]> queue = new ArrayDeque<>();
        distance[1] = 0;
        queue.offer(new int[]{1, 0});
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (Edge e : edges[curr[0]]) {
                if (distance[e.to] <= curr[1] + 1) {
                    continue;
                }
                distance[e.to] = curr[1] + 1;
                queue.offer(new int[]{e.to, curr[1] + 1});
            }
        }
        
        int maxDist = distance[1];
        for (int i = 2; i <= n; i++) {
            maxDist = Math.max(maxDist, distance[i]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDist) {
                answer++;
            }
        }
        
        return answer;
    }
}