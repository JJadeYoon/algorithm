import java.io.*;
import java.util.*;

class Main {
    private static int minPrice = Integer.MAX_VALUE;
    private static List<Integer> minIdxs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] minNutrition = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minNutrition[i] = Integer.parseInt(st.nextToken());
        }

        int[][] foods = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                foods[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(foods, minNutrition, new boolean[n], -1, 0, 0, 0, 0, 0, new ArrayList<>());

        if (minPrice == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }

        System.out.println(minPrice);
        Collections.sort(minIdxs);
        StringBuilder sb = new StringBuilder();
        for (Integer idx : minIdxs) {
            sb.append(idx + 1).append(" ");
        }
        System.out.print(sb);
    }

    private static void backtrack(int[][] foods, int[] minNutrition, boolean[] visited, int idx, int p, int f, int s, int v, int price, List<Integer> idxs) {
        if (isOverMin(minNutrition, p, f, s, v) && minPrice > price) {
            minPrice = price;
            minIdxs = new ArrayList<>(idxs);
            return;
        }

        for (int i = idx + 1; i < foods.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (price + foods[i][4] > minPrice) {
                continue;
            }

            idxs.add(i);
            visited[i] = true;

            backtrack(foods, minNutrition, visited, i, p + foods[i][0], f + foods[i][1], s + foods[i][2], v + foods[i][3], price + foods[i][4], idxs);

            idxs.remove(idxs.size() - 1);
            visited[i] = false;
        }
    }

    private static boolean isOverMin(int[] minNutrition, int p, int f, int s, int v) {
        return p >= minNutrition[0] && f >= minNutrition[1] && s >= minNutrition[2] && v >= minNutrition[3];
    }
}