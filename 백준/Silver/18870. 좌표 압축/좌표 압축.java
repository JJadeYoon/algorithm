import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] points = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st.nextToken());
            temp[i] = points[i];
        }

        Arrays.sort(temp);
        Map<Integer, Integer> hm = new HashMap<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(temp[i])) {
                hm.put(temp[i], index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : points) {
            sb.append(hm.get(p)).append(" ");
        }

        System.out.print(sb.toString());
    }
}