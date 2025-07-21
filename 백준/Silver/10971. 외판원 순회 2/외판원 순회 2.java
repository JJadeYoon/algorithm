import java.io.*;
import java.util.*;

public class Main {
    private static int totalCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] w = new int[n][n];
        for (int i = 0; i < n; i++) {
            w[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            backtrack(visited, w, 1, i, 0, i);
            visited[i] = false;
        }

        System.out.print(totalCost);
    }

    private static void backtrack(boolean[] visited, int[][] w, int count, int curr, int cost, int start) {
        if (count == visited.length) {
            if (w[curr][start] == 0) {
                return;
            }
            totalCost = Math.min(totalCost, cost + w[curr][start]);
            return;
        }

        // 다음 경로 선정
        for (int next = 0; next < visited.length; next++) {
            if (visited[next] || w[curr][next] == 0) {
                continue;
            }
            if (cost + w[curr][next] > totalCost) {
                continue;
            }
            visited[next] = true;
            backtrack(visited, w, count + 1, next, cost + w[curr][next], start);
            visited[next] = false;
        }
    }
}