import java.util.*;

class Solution {
    private static class Edge {
        int v; // 노드 번호
        int cost; // 가중치

        Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    // 각 노드의 간선을 저장하는 리스트 배열
    static List<Edge>[] graph;
    // 각 노드의 방문을 확인하는 배열
    static boolean[] visit;
    // 최단 거리 테이블
    static int[] dist;

    public int solution(int N, int[][] road, int K) {

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        // 간선 저장
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

        System.out.println(Arrays.toString(dist));

        return answer;
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (!visit[curr.v]) {
                visit[curr.v] = true;
            }

            for (Edge next : graph[curr.v]) {
                if (!visit[next.v] && dist[next.v] > curr.cost + next.cost) {
                    dist[next.v] = curr.cost + next.cost;
                    pq.add(new Edge(next.v, dist[next.v]));
                }
            }
        }
    }
}