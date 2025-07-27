import java.io.*;
import java.util.*;

public class Main {
    private static final int[][] directions = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }
            bw.write(getCount(map) + "");
            if (i < t - 1) {
                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static int getCount(boolean[][] map) {
        int n = map.length;
        int m = map[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] && !visited[i][j]) {
                    dfs(map, visited, i , j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(boolean[][] map, boolean[][] visited, int currRow, int currCol) {
        visited[currRow][currCol] = true;
        for (int[] d : directions) {
            int nextRow = currRow + d[0];
            int nextCol = currCol + d[1];
            if (isValid(nextRow, nextCol, visited) && map[nextRow][nextCol]) {
                dfs(map, visited, nextRow, nextCol);
            }
        }
    }

    private static boolean isValid(int row, int col, boolean[][] visited) {
        int n = visited.length;
        int m = visited[0].length;
        if (row >= 0 && row < n && col >= 0 && col < m && !visited[row][col]) {
            return true;
        }
        return false;
    }
}