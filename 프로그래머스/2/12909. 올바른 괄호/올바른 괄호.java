import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) {
                deque.offer(c);
                continue;
            }
            
            if (c == ')') {
                deque.poll();
            } else {
                deque.offer(c);
            }
        }
        
        return deque.isEmpty() ? true : false;
    }
}