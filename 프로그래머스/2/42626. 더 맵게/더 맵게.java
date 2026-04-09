import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int cnt = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b * 2);
            cnt++;
        }
        
        return pq.peek() >= K ? cnt : -1;
    }
}