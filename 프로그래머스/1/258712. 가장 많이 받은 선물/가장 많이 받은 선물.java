import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> ni = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            ni.put(friends[i], i);
        }
        
        int[] scores = new int[friends.length];
        int[][] records = new int[friends.length][friends.length];
        StringTokenizer st;
        for (String gift : gifts) {
            st = new StringTokenizer(gift);
            int g = ni.get(st.nextToken());
            int r = ni.get(st.nextToken());
            records[g][r]++;
            scores[g]++;
            scores[r]--;
        }
        
        int[] answers = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {            
            int next = 0;
            
            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }
                
                if (records[i][j] > records[j][i]) {
                    next++;
                } else if (records[i][j] == records[j][i] 
                           && scores[i] > scores[j]) {
                    next++;
                }
            }
            
            answers[i] = next;
        }
        
        Arrays.sort(answers);
        return answers[answers.length - 1];
    }
}