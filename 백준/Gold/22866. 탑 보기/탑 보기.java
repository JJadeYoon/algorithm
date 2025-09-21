import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] buildings = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        int[] counts = new int[n + 1];
        int[] nearest = new int[n + 1];
        Arrays.fill(nearest, Integer.MAX_VALUE);

        // 왼쪽 방향 따로, 오른쪽 방향 따로 구해야 함
        // 왼쪽
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                stack.pop();
            }
            int count = stack.size();
            if (count > 0) {
                nearest[i] = stack.peek();
            }
            counts[i] += stack.size();

            stack.push(i);
        }

        // 오른쪽
        stack = new Stack<>();
        for (int i = n; i > 0; i--) {
            while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                stack.pop();
            }
            int count = stack.size();
            if (count > 0) {
                if (Math.abs(stack.peek() - i) < Math.abs(nearest[i] - i)) {
                    nearest[i] = stack.peek();
                } else if (Math.abs(stack.peek() - i) == Math.abs(nearest[i] - i)) {
                    nearest[i] = Math.min(nearest[i], i);
                }
            }
            counts[i] += stack.size();

            stack.push(i);
        }

        for (int i = 1; i <= n; i++) {
            if (counts[i] > 0) {
                bw.write(counts[i] + " " + nearest[i]);
            } else {
                bw.write(0 + "");
            }

            if (i < n) {
                bw.write('\n');
            }
        }
        bw.flush();
    }
}