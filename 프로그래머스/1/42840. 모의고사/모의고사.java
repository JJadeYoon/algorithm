import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] tester1 = {1, 2, 3, 4, 5};
        int[] tester2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] tester3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = {0, 0, 0};
        int[][] testers = {tester1, tester2, tester3};

        for (int i = 0; i < scores.length; i++) {
            scores[i] = evaluate(testers[i], answers);
        }

        int maxScore = 0;
        for (int s : scores) {
            if (maxScore < s) {
                maxScore = s;
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (maxScore == scores[i]) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int evaluate(int[] tester, int[] answers) {
        int count = 0;
        int idx = 0;
        for (int a : answers) {
            if (tester[idx] == a) {
                count++;
            }
            idx++;
            if (idx == tester.length) {
                idx = 0;
            }
        }
        return count;
    }
}