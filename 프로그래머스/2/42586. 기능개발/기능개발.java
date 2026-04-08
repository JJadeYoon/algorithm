import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if (remain % speeds[i] != 0) {
                day++;
            }
            queue.offer(day);
        }
        
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int cnt = 1;
            while (!queue.isEmpty() && curr >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}