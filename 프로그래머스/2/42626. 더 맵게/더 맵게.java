import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        
        if (pq.isEmpty()) {
            return -1;
        }
        
        int count = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int minScov = pq.poll();
            int secondMinScov = pq.poll();
            pq.add(minScov + 2 * secondMinScov);
            count++;
        }
        
        if (pq.peek() < K) {
            count = -1;
        }
        
        return count;
    }
}