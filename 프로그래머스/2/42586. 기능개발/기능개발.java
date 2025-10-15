import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            int remains = 100 - progresses[i];
            int days = remains / speeds[i];
            if (remains % speeds[i] != 0) {
                days++;
            }
            queue.offer(days);
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int count = 1;
            while (!queue.isEmpty() && queue.peek() <= curr) {
                queue.poll();
                count++;
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}