import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> wq = new ArrayDeque<>(); // words
        Queue<Integer> sq = new ArrayDeque<>(); // steps
        wq.offer(begin);
        sq.offer(0);
        boolean[] visited = new boolean[words.length];
        while(!wq.isEmpty()) {
            String curw = wq.poll();
            int curs = sq.poll();
            if (target.equals(curw)) {
                return curs;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) {
                    continue;
                }
                String nxtw = words[i];
                if (!isChangable(curw, nxtw)) {
                    continue;
                }
                wq.offer(nxtw);
                sq.offer(curs + 1);
                visited[i] = true;
            }
        }
        
        return 0;
    }
    
    private boolean isChangable(String from, String to) {
        int diff = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}