import java.io.*;
import java.util.*;

public class Main {
    private static final int BLANK = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;

    private static final int[][] directions = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 입력
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 빈칸 좌표
        List<Point> blankPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == BLANK) {
                    blankPoints.add(new Point(i, j));
                }
            }
        }

        int countSafeMax = 0;
        for (int i = 0; i < blankPoints.size(); i++) {
            for (int j = i + 1; j < blankPoints.size(); j++) {
                for (int k = j + 1; k < blankPoints.size(); k++) {
                    Point wall1 = blankPoints.get(i);
                    Point wall2 = blankPoints.get(j);
                    Point wall3 = blankPoints.get(k);

                    int[][] wall = new int[n][m];
                    for (int l = 0; l < n; l++) {
                        System.arraycopy(map[l], 0, wall[l], 0, m);
                    }
                    wall[wall1.row][wall1.col] = WALL;
                    wall[wall2.row][wall2.col] = WALL;
                    wall[wall3.row][wall3.col] = WALL;

                    // 바이러스 확산
                    spread(wall);
                    countSafeMax = Math.max(countSafeMax, countSafe(wall));
                }
            }
        }

        System.out.print(countSafeMax);
    }

    private static int countSafe(int[][] map) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == BLANK) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void spread(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == VIRUS && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, map, visited);
                }
            }
        }
    }

    private static void dfs(int row, int col, int[][] map, boolean[][] visited) {
        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (isValid(nextRow, nextCol, visited) && map[nextRow][nextCol] == BLANK) {
                visited[nextRow][nextCol] = true;
                map[nextRow][nextCol] = VIRUS;
                dfs(nextRow, nextCol, map, visited);
            }
        }
    }

    private static boolean isValid(int row, int col, boolean[][] visited) {
        if (row >= 0 && col >= 0 && row < visited.length && col < visited[0].length) {
            return !visited[row][col];
        } else {
            return false;
        }
    }
}