import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        final int INF = Integer.MAX_VALUE / 2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dist = new int[n + 1][n + 1];
        int[][] nxt = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[from][to] = Math.min(dist[from][to], w);
            nxt[from][to] = to;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        nxt[i][j] = nxt[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    bw.write("0 ");
                } else {
                    bw.write(dist[i][j] + " ");
                }
            }
            bw.write("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 0 || dist[i][j] == INF) {
                    bw.write("0\n");
                    continue;
                }
                List<Integer> path = new ArrayList<>();
                int start = i;
                while (start != j) {
                    path.add(start);
                    start = nxt[start][j];
                }
                path.add(j);
                bw.write(path.size() + " ");
                for (int p : path) {
                    bw.write(p + " ");
                }
                bw.write("\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}