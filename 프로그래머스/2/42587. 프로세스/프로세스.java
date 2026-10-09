import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i]);
        }
        
        int answer = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[1] < pq.peek()) {
                q.offer(curr);
                continue;
            }
            
            pq.poll();
            if (location == curr[0]) {
                return answer;
            }
            answer++;
        }
        
        return answer;
    }
}