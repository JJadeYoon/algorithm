import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];

        for (int[] p : puddles) {
            int x = p[0] - 1;
            int y = p[1] - 1;
            map[y][x] = -1;
        }

        if (map[0][0] == -1) return 0;
        map[0][0] = 1;

        // 첫 행
        for (int j = 1; j < m; j++) {
            if (map[0][j] == -1) {
                map[0][j] = 0;
            } else {
                map[0][j] = map[0][j - 1];
            }
        }

        // 첫 열
        for (int i = 1; i < n; i++) {
            if (map[i][0] == -1) {
                map[i][0] = 0;
            } else {
                map[i][0] = map[i - 1][0];
            }
        }

        // 나머지
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                long up = map[i - 1][j];
                long left = map[i][j - 1];
                map[i][j] = (int) ((up + left) % MOD);
            }
        }

        return map[n - 1][m - 1];
    }
}