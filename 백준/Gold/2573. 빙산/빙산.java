import java.io.*;
import java.util.*;

class Main {

    private static final int[][] directions = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input != 0) {
                    map[i][j] = input;
                }
            }
        }

        // 주변에 붙어 있는 0의 개수 만큼 줄어든다
        // 분리되는 시간? -> 계속해서 BFS/DFS로 게산해야 하나?
        int t = 0;
        while (true) {
            int iceBergCount = countIceBerg(map);

            if (iceBergCount > 1) {
                System.out.print(t);
                return;
            } else if (iceBergCount == 0) {
                break;
            }
            t++;
        }

        System.out.print(0);
    }

    private static int countIceBerg(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        int[][] newMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }

                if (map[i][j] != 0) {
                    visited[i][j] = true;
                    count++;
                    newMap[i][j] = Math.max(0, map[i][j] - countBorder(map, i, j));
                    dfs(map, visited, i, j, newMap);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = newMap[i][j];
            }
        }
        return count;
    }

    private static void dfs(int[][] map, boolean[][] visited, int row, int col, int[][] newMap) {
        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (nextRow < 0 || nextCol < 0 || nextRow >= visited.length
                || nextCol >= visited[0].length) {
                continue;
            }

            if (visited[nextRow][nextCol] || map[nextRow][nextCol] == 0) {
                continue;
            }

            newMap[nextRow][nextCol] = Math.max(0, map[nextRow][nextCol] - countBorder(map, nextRow, nextCol));


            visited[nextRow][nextCol] = true;
            dfs(map, visited, nextRow, nextCol, newMap);
        }
    }

    private static int countBorder(int[][] map, int row, int col) {
        int count = 0;

        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (nextRow < 0 || nextCol < 0 || nextRow >= map.length
                || nextCol >= map[0].length) {
                continue;
            }

            if (map[nextRow][nextCol] == 0) {
                count++;
            }
        }

        return count;
    }
}