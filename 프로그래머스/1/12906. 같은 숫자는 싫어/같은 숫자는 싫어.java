import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new LinkedList<>();
        for (int n : arr) {
            if (!deque.isEmpty() && deque.peekLast() == n) {
                continue;
            }
            deque.offer(n);
        }

        int answerSize = deque.size();
        int[] answer = new int[answerSize];
        for (int i = 0; i < answerSize; i++) {
            answer[i] = deque.poll();
        }

        return answer;
    }
}