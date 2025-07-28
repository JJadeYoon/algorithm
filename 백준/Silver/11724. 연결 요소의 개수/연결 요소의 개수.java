import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] edgeList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int inputU = Integer.parseInt(st.nextToken());
            int inputV = Integer.parseInt(st.nextToken());
            edgeList[inputU].add(inputV);
            edgeList[inputV].add(inputU);
        }

        int count = 0;
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(visited, edgeList, i);
            count++;
        }

        System.out.print(count);
    }

    private static void dfs(boolean[] visited, ArrayList<Integer>[] edgeList, int start) {
        visited[start] = true;
        ArrayList<Integer> edges = edgeList[start];
        for (Integer edge : edges) {
            if (!visited[edge]) {
                dfs(visited, edgeList, edge);
            }
        }
    }
}