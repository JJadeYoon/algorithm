import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int row;
        int col;
        int dist;
        boolean hasCrashed;

        Node(int row, int col, int dist, boolean hasCrashed) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.hasCrashed = hasCrashed;
        }
    }

    private static final int[][] directions = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private static boolean isValid(boolean[][][] visited, int row, int col, boolean hasCrashed) {
        int crashedIndex = hasCrashed ? 1 : 0;

        return !visited[row][col][crashedIndex];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n, m 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        br.close();

        // 3차원 visited 배열: [row][col][hasCrashed ? 1 : 0]
        boolean[][][] visited = new boolean[n][m][2];
        Queue<Node> nodeQueue = new ArrayDeque<>();

        nodeQueue.offer(new Node(0, 0, 1, false));
        visited[0][0][0] = true; // 벽을 부수지 않고 시작점 방문

        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();
            int currRow = currNode.row;
            int currCol = currNode.col;
            int currDist = currNode.dist;
            boolean currHasCrashed = currNode.hasCrashed;

            // 목표 지점에 도달했는지 확인
            if (currRow == n - 1 && currCol == m - 1) {
                System.out.print(currDist);
                return;
            }

            // 4방향 탐색
            for (int[] dir : directions) {
                int row = currRow + dir[0];
                int col = currCol + dir[1];
                boolean hasCrashed = currHasCrashed;

                // 경계 확인
                if (row < 0 || col < 0 || row >= n || col >= m) {
                    continue;
                }

                // 벽인 경우 처리
                if (map[row][col] == 1) {
                    if (hasCrashed) {
                        continue; // 이미 벽을 부쳤으므로 불가능
                    } else {
                        hasCrashed = true; // 벽을 부숨
                    }
                }

                // 해당 상태로 이미 방문했는지 확인
                if (isValid(visited, row, col, hasCrashed)) {
                    int crashedIndex = hasCrashed ? 1 : 0;
                    visited[row][col][crashedIndex] = true;
                    nodeQueue.offer(new Node(row, col, currDist + 1, hasCrashed));
                }
            }
        }

        System.out.print(-1);
    }
}
