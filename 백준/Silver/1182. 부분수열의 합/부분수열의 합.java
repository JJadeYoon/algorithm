import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        backtrack(arr, s, 0, 0);
        if (s == 0) {
            answer--;
        }

        System.out.print(answer);
    }

    private static void backtrack(int[] arr, int s, int total, int idx) {
        if (idx == arr.length) {
            if (total == s) {
                answer++;
            }
            return;
        }
        backtrack(arr, s, total + arr[idx], idx + 1);
        backtrack(arr, s, total, idx + 1);
    }
}