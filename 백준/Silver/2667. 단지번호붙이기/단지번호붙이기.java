import java.io.*;
import java.util.*;

public class Main {
    private static final int[][] directions = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int n = Integer.parseInt(br.readLine());
        int[][] houseMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            houseMap[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        boolean[][] visited = new boolean[n][n];
        List<Integer> arrayList = new ArrayList<>();
        int village = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (houseMap[i][j] == 1 && !visited[i][j]) {
                    village++;
                    visited[i][j] = true;
                    arrayList.add(bfs(houseMap, visited, i, j) + 1);
                }
            }
        }

        Collections.sort(arrayList);
        bw.write(village + "");
        for (Integer i : arrayList) {
            bw.write("\n" + i);
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs(int[][] map, boolean[][] visited, int row, int col) {
        Queue<Integer> rowQueue = new ArrayDeque<>();
        Queue<Integer> colQueue = new ArrayDeque<>();
        int count = 0;

        rowQueue.offer(row);
        colQueue.offer(col);

        while(!rowQueue.isEmpty()) {
            int tempRow = rowQueue.poll();
            int tempCol = colQueue.poll();

            for (int[] direction : directions) {
                int nextRow = tempRow + direction[0];
                int nextCol = tempCol + direction[1];

                if (isValid(map, visited, nextRow, nextCol)) {
                    visited[nextRow][nextCol] = true;
                    rowQueue.offer(nextRow);
                    colQueue.offer(nextCol);
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValid(int[][] map, boolean[][] visited, int row, int col) {
        if (row >= 0 && col >= 0 && row < map.length && col < map[0].length) {
            return map[row][col] == 1 && !visited[row][col];
        }
        return false;
    }
}