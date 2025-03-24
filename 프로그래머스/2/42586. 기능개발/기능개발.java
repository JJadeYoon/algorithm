import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> stack = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int day = (int) Math.ceil(remain);
            
            if (!stack.isEmpty() && stack.peek() < day) {
                answer.add(stack.size());
                stack.clear();
            }
            
            stack.offer(day);
        }
        
        answer.add(stack.size());
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}