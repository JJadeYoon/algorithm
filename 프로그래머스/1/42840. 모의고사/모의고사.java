import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {

        int[][] testers = {
                {1, 2, 3, 4, 5}, 
                {2, 1, 2, 3, 2, 4, 2, 5}, 
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[testers.length];
        for (int i = 0; i < testers.length; i++) {
            int count = 0;
            for (int j = 0; j < answers.length; j++) {
                if (testers[i][j % testers[i].length] == answers[j]) {
                    count++;
                }
            }
            scores[i] = count;
        }

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (maxScore == scores[i]) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}