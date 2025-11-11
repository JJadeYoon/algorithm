import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        final int[][] ans = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                if (answers[i] == ans[j][i % ans[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = scores[0];
        for (int i = 1; i < scores.length; i++) {
            maxScore = Math.max(maxScore, scores[i]);
        }
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                arr.add(i);
            }
        }
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i) + 1;
        }
        
        return answer;
    }
}