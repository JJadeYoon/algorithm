import java.io.*;
import java.util.*;

public class Main {

    private static int rowCnt = 3;
    private static int colCnt = 3;

    private static int[][] a = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t = 0;
        while (t <= 100 && rowCnt <= 100 && colCnt <= 100) {
            if (a[r][c] == k) {
                System.out.print(t);
                return;
            }

            if (rowCnt >= colCnt) { // R 연산
                calcR();
            } else { // C 연산
                calcC();
            }

            t++;
        }

        System.out.print(-1);
    }

    private static void calcR() { // 모든 행 단위 정렬
        int temp = colCnt;
        for (int i = 1; i <= rowCnt; i++) {
            Map<Integer, Integer> hm = new HashMap<>();
            for (int j = 1; j <= colCnt; j++) {
                if (a[i][j] != 0) {
                    int n = hm.getOrDefault(a[i][j], 0);
                    hm.put(a[i][j], n + 1);
                    a[i][j] = 0;
                }
            }

            List<Integer> keySet = new ArrayList<>(hm.keySet());

            temp = Math.max(temp, keySet.size() * 2);
            temp = Math.min(temp, 100);

            keySet.sort((k1, k2) -> {
                if (hm.get(k1) == hm.get(k2)) {
                    return k1 - k2;
                } else {
                    return hm.get(k1) - hm.get(k2);
                }
            });

            int idx = 1;
            for (int j = 0; j < keySet.size() && idx < 100; j++) {
                a[i][idx++] = keySet.get(j);
                a[i][idx++] = hm.get(keySet.get(j));
            }
        }
        colCnt = temp;
    }

    private static void calcC() {
        int temp = rowCnt;
        for (int i = 1; i <= colCnt; i++) {
            Map<Integer, Integer> hm = new HashMap<>();
            for (int j = 1; j <= rowCnt; j++) {
                if (a[j][i] != 0) {
                    int n = hm.getOrDefault(a[j][i], 0);
                    hm.put(a[j][i], n + 1);
                }
                a[j][i] = 0;
            }

            List<Integer> keySet = new ArrayList<>(hm.keySet());

            temp = Math.max(temp, keySet.size() * 2);
            temp = Math.min(temp, 100);

            keySet.sort((k1, k2) -> {
                if (hm.get(k1) == hm.get(k2)) {
                    return k1 - k2;
                } else {
                    return hm.get(k1) - hm.get(k2);
                }
            });

            int idx = 1;
            for (int j = 0; j < keySet.size() && idx < 100; j ++) {
                a[idx++][i] = keySet.get(j);
                a[idx++][i] = hm.get(keySet.get(j));
            }
        }
        rowCnt = temp;
    }
}