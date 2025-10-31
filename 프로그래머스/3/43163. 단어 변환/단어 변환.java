import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<String> wordQueue = new ArrayDeque<>();
        Queue<Integer> distQueue = new ArrayDeque<>();
        wordQueue.offer(begin);
        distQueue.offer(0);
        while (!wordQueue.isEmpty()) {
            String word = wordQueue.poll();
            int dist = distQueue.poll();
            if (word.equals(target)) {
                return dist;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (isChangeable(word, words[i])) {
                    visited[i] = true;
                    wordQueue.offer(words[i]);
                    distQueue.offer(dist + 1);
                }
            }
        }
        return 0;
    }
    
    private boolean isChangeable(String from, String to) {
        int count = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}