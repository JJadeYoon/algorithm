import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] isVisit = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisit[i]) {
                answer += dfs(isVisit, i, n, computers);
            }
        }
        return answer;
    }
    
    private int dfs(boolean[] isVisit, int index, int n, int[][] computers) {
        isVisit[index] = true;
        for (int i = 0; i < n; i++) {
            if (computers[index][i] == 1) {
                if (!isVisit[i]) {
                    dfs(isVisit, i, n, computers);
                }
            }
        }
        return 1;
    }
}