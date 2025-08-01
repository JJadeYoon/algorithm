import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        backtrack(numbers, new boolean[n], m, new ArrayList<>());

        System.out.print(answer);
    }

    private static void backtrack(int[] numbers, boolean[] visited, int m, List<Integer> arr) {
        if (arr.size() == m) {
            answer.append(listToString(arr)).append("\n");
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) {
                continue;
            }
            arr.add(numbers[i]);
            visited[i] = true;
            backtrack(numbers, visited, m, arr);
            arr.remove(arr.size() - 1);
            visited[i] = false;
        }
    }

    private static String listToString(List<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
            if (i != arr.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}