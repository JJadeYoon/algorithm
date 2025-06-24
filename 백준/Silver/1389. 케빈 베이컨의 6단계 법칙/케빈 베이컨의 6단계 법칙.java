import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] relationships = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()); // StringTokenizer로 통일
            relationships[i][0] = Integer.parseInt(st.nextToken());
            relationships[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int[] counts = new int[n + 1];
        
        // 각 사람의 케빈 베이컨 수 계산
        for (int i = 1; i <= n; i++) {
            int totalDistance = 0;
            for (int j = 1; j <= n; j++) {
                totalDistance += getShortestDistance(i, j, relationships, n);
            }
            counts[i] = totalDistance;
        }
        
        // 최소 케빈 베이컨 수를 가진 사람 찾기
        int minBacon = Arrays.stream(counts, 1, n + 1).min().orElse(0);
        for (int i = 1; i <= n; i++) {
            if (counts[i] == minBacon) {
                bw.write(String.valueOf(i));
                break;
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    /**
     * BFS를 사용하여 두 사람 사이의 최단 거리를 구합니다.
     */
    private static int getShortestDistance(int start, int target, int[][] relationships, int n) {
        if (start == target) {
            return 0;
        }
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> nodeQueue = new LinkedList<>();
        Queue<Integer> distanceQueue = new LinkedList<>();
        
        // BFS 초기화
        visited[start] = true;
        nodeQueue.offer(start);
        distanceQueue.offer(0);
        
        while (!nodeQueue.isEmpty()) {
            int currentNode = nodeQueue.poll();
            int currentDistance = distanceQueue.poll();
            
            // 현재 노드와 연결된 모든 노드 확인
            for (int[] relationship : relationships) {
                int nextNode = getConnectedNode(relationship, currentNode);
                
                if (nextNode != -1 && !visited[nextNode]) {
                    if (nextNode == target) {
                        return currentDistance + 1;
                    }
                    
                    visited[nextNode] = true;
                    nodeQueue.offer(nextNode);
                    distanceQueue.offer(currentDistance + 1);
                }
            }
        }
        
        return -1; // 연결되지 않은 경우
    }
    
    /**
     * 주어진 관계에서 현재 노드와 연결된 다른 노드를 반환합니다.
     * 연결되지 않았으면 -1을 반환합니다.
     */
    private static int getConnectedNode(int[] relationship, int currentNode) {
        if (relationship[0] == currentNode) {
            return relationship[1];
        } else if (relationship[1] == currentNode) {
            return relationship[0];
        }
        return -1;
    }
}