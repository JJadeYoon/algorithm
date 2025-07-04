import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                meetings[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int count = 1;
        int idx = 0;
        int lastEnd = meetings[idx][1];
        for (int i = 1; i < n; i++) {
           if (meetings[i][0] >= lastEnd) {
               lastEnd = meetings[i][1];
               count++;
           }
        }

        System.out.print(count);
    }
}