import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        
        int count = 0;
        for (String op : operations) {
            if (op.startsWith("I")) {
                int num = Integer.parseInt(op.substring(2));
                minPQ.offer(num);
                maxPQ.offer(num);
                count++;
            } else if (op.equals("D 1")) {
                if (count <= 0) {
                    continue;
                }
                int num = maxPQ.poll();
                minPQ.remove(num);
                count--;
            } else {
                if (count <= 0) {
                    continue;
                }
                int num = minPQ.poll();
                maxPQ.remove(num);
                count--;
            }
        }
        
        int max = 0;
        int min = 0;
        if (count > 1) {
            max = maxPQ.poll();
            min = minPQ.poll();
        } else if (count > 0) {
            max = min = maxPQ.poll();
        }
        
        int[] answer = {max, min};
        return answer;
    }
}