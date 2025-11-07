import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import javax.swing.Icon;

public class Main {

    private static int[] p;
    private static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        p = new int[n + 1];
        Arrays.fill(p, -1);
        p[1] = 0;
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            bw.write(p[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int curr) {
        for (int nxt : adj[curr]) {
            if (p[curr] == nxt) { // 자식 방향으로만 순회하도록
                continue;
            }
            p[nxt] = curr;
            dfs(nxt);
        }
    }
}