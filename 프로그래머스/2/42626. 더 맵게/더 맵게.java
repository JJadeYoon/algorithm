import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int answer = 0;
        while (pq.peek() < K) {
            pq.offer(pq.poll() + pq.poll() * 2);
            answer++;
            if (pq.size() <= 1 && pq.peek() < K) {
                return -1;
            }
        }

        return answer;
    }
}