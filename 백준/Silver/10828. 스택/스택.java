import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < st.countTokens(); j++) {
                switch (st.nextToken()) {
                    case "push":
                        stack.push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        try {
                            bw.write(stack.pop() + "\n");
                        } catch (Exception e) {
                            bw.write(-1 + "\n");
                        }
                        break;
                    case "size":
                        bw.write(stack.size() + "\n");
                        break;
                    case "empty":
                        if (stack.isEmpty()) {
                            bw.write(1 + "\n");
                        } else {
                            bw.write(0 + "\n");
                        }
                        break;
                    case "top":
                        if (stack.isEmpty()) {
                            bw.write(-1 + "\n");
                        } else {
                            bw.write(stack.peek() + "\n");
                        }
                        break;
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}