import java.io.*;
import java.util.*;

public class Main {
    private static class Rect {
        int row, col, size;

        Rect(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int white = 0;
        int blue = 0;
        Queue<Rect> queue = new ArrayDeque<>();
        queue.offer(new Rect(0, 0, n));
        while (!queue.isEmpty()) {
            Rect rect = queue.poll();
            int size = rect.size;
            int startRow = rect.row;
            int startCol = rect.col;

            int flag = isComplete(rect, map);
            if (flag == 0) {
                white++;
            } else if (flag == 1) {
                blue++;
            } else {
                int nextSize = size / 2;
                queue.offer(new Rect(startRow, startCol, nextSize));
                queue.offer(new Rect(startRow + nextSize, startCol, nextSize));
                queue.offer(new Rect(startRow, startCol + nextSize, nextSize));
                queue.offer(new Rect(startRow + nextSize, startCol + nextSize, nextSize));
            }
        }

        System.out.println(white);
        System.out.print(blue);
    }

    private static int isComplete(Rect rect, int[][] map) {
        int size = rect.size;
        int startRow = rect.row;
        int startCol = rect.col;
        int color = map[startRow][startCol];

        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {
                if (map[i][j] != color) {
                    return -1;
                }
            }
        }
        return color;
    }
}