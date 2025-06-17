import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = 0; i <= citations.length; i++) {
            int count = citations.length;
            for (int j = 0; j < citations.length; j++) {
                if (i > citations[j]) {
                    count--;
                }
            }
            if (count >= i) {
                answer = i;
            }
        }
        return answer;
    }
}