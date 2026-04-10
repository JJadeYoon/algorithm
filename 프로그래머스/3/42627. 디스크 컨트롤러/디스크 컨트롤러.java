import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // n번째, 요청 시간, 소요 시간
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < jobs.length; i++) {
            queue.offer(new int[]{i, jobs[i][0], jobs[i][1]}); 
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] != b[2] ? a[2] - b[2] : a[0] - b[0]
        );
        
        int t = 0;
        int total = 0;
        while (!queue.isEmpty() || !pq.isEmpty()) {
            while (!queue.isEmpty() && queue.peek()[1] <= t) {
                pq.offer(queue.poll());
            }
            
            if (pq.isEmpty()) {
                t = queue.peek()[1];
            } else {
                int[] curr = pq.poll();
                total += t + curr[2] - curr[1];
                t += curr[2];
            }
        }
        
        return total / jobs.length;
    }
}