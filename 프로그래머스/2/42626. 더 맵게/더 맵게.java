import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }

        if (pq.isEmpty()) {
            return -1;
        } else if (pq.peek() >= K) {
            return 0;
        }

        int count = 0;
        while(pq.size() > 1) {
            int i = pq.poll();
            pq.offer(i + 2 * pq.poll());
            count++;
            if (pq.peek() >= K) {
                return count;
            }
        }

        return -1;
    }
}