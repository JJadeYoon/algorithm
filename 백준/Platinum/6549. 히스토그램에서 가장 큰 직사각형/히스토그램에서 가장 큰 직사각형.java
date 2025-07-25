import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        StringTokenizer st;
        while (!(input = br.readLine()).equals("0")) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int[] histogram = new int[n];
            for (int i = 0; i < n; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            bw.write(getMaxArea(histogram) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static long getMaxArea(int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i <= histogram.length; i++) {
            int currHeight = (i == histogram.length) ? 0 : histogram[i];

            // 단조 증가가 안될 때
            while (!stack.isEmpty() && currHeight < histogram[stack.peek()]) {
                int height = histogram[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, (long) width * height);
            }

            stack.push(i);
        }

        return maxArea;
    }
}