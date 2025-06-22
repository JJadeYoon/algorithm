import java.io.*;
import java.util.*;

public class Main {
    public static class Tomato {
        int x, y, day;

        Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String[][] tomatoes = new String[n][m];
        for (int i = 0; i < n; i++) {
            tomatoes[i] = br.readLine().split(" ");
        }

        int[][] directions = {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };

        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j].equals("1")) {
                    queue.offer(new Tomato(i, j, 0));
                }
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for (int[] dir : directions) {
                int x = tomato.x + dir[0];
                int y = tomato.y + dir[1];
                int day = tomato.day;
                answer = day;
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (tomatoes[x][y].equals("0")) {
                        tomatoes[x][y] = "1";
                        queue.offer(new Tomato(x, y, day + 1));
                    }
                }
            }
        }

        // 다 익지 않은 토마토가 있는 경우 0 반환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j].equals("0")) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }
            }
        }
        bw.write(answer + "");
        bw.flush();
    }
}