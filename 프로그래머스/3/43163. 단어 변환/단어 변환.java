import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 최단거리 -> BFS
        Arrays.sort(words);

        // boolean[] visited = new boolean[words.length + 1];
        Map<String, Boolean> visited = new HashMap<>();

        Queue<String> wordQueue = new ArrayDeque<>();
        wordQueue.offer(begin);
        Queue<Integer> stepQueue = new ArrayDeque<>();
        stepQueue.offer(0);
        visited.put("begin", true);

        while(!wordQueue.isEmpty()) {
            String currWord = wordQueue.poll();
            int currStep = stepQueue.poll();

            if (currWord.equals(target)) {
                return currStep;
            }

            for (String word : words) {
                if (visited.getOrDefault(word, false)) {
                    continue;
                }
                if (countDiff(word, currWord) <= 1) {
                    wordQueue.offer(word);
                    stepQueue.offer(currStep + 1);
                    visited.put(word, true);
                }
            }
        }

        return 0;
    }

    private int countDiff(String u, String v) {
        int count = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) != v.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}