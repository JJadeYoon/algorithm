import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken()); // M은 최대 20억이므로 long 사용
        PriorityQueue<Integer> heights = new PriorityQueue<>(Comparator.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights.offer(Integer.parseInt(st.nextToken()));
        }

        int h = heights.poll(); // 가장 높은 나무 높이
        long sum = 0; // 잘린 나무의 누적량 (long으로 처리)
        int count = 1; // 현재까지 처리한 나무 개수

        // 높이를 단계적으로 내려가면서 잘린 나무량 계산
        while (!heights.isEmpty() && sum < m) {
            int prev = h;
            h = heights.poll(); // 다음으로 높은 나무 높이
            sum += (long)(prev - h) * count; // 이전 높이와 현재 높이 차이만큼 잘림
            if (sum >= m) {
                break;
            }
            count++; // 처리한 나무 개수 증가
        }

        if (sum > m) {
            h += (sum - m) / count;
        } else {
            while (sum < m && h > 0) {
                h--;
                sum += count; 
            }
        }

        System.out.print(h);
    }
}