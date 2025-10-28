import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i]);
        }
        
        int answer = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            while (!pq.isEmpty() && pq.peek() > curr[1]) {
                queue.offer(curr);
                curr = queue.poll();
            }
            pq.poll();
            if (curr[0] == location) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}