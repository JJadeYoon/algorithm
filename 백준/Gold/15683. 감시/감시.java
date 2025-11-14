import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int[][] dir = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] empty = new int[n][m];
        int answer = 0;
        List<int[]> cctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctv.add(new int[]{i, j});
                }
                if (map[i][j] == 0) {
                    answer++;
                }
            }
        }

        for (int tmp = 0; tmp < (1 << (2 * cctv.size())); tmp++) { // tmp: cctv 방향의 경우
            // empty 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    empty[i][j] = map[i][j];
                }
            }

            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int d = brute % 4;
                brute /= 4;

                int c = cctv.get(i)[0];
                int r = cctv.get(i)[1];

                if (map[c][r] == 1) {
                    chk(c, r, map, empty, d);
                } else if (map[c][r] == 2) {
                    chk(c, r, map, empty, d);
                    chk(c, r, map, empty, d + 2);
                } else if (map[c][r] == 3) {
                    chk(c, r, map, empty, d);
                    chk(c, r, map, empty, d + 1);
                } else if (map[c][r] == 4) {
                    chk(c, r, map, empty, d);
                    chk(c, r, map, empty, d + 1);
                    chk(c, r, map, empty, d + 2);
                } else {
                    chk(c, r, map, empty, d);
                    chk(c, r, map, empty, d + 1);
                    chk(c, r, map, empty, d + 2);
                    chk(c, r, map, empty, d + 3);
                }
            }

            int cnt = 0;
            for (int[] es : empty) {
                for (int e : es) {
                    if (e == 0) {
                        cnt++;
                    }
                }
            }
            answer = Math.min(answer, cnt);
        }

        System.out.print(answer);
    }

    private static boolean isOut(int c, int r, int n, int m) {
        return c < 0 || c >= n || r < 0 || r >= m;
    }

    private static void chk(int c, int r, int[][] map, int[][] empty, int d) {
        d %= 4;
        while (true) {
            c += dir[d][0];
            r += dir[d][1];
            if (isOut(c, r, map.length, map[0].length) || map[c][r] == 6) {
                return;
            }
            if (map[c][r] != 0) {
                continue;
            }
            empty[c][r] = 7;
        }
    }
}