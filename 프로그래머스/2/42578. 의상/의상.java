import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> hm = new HashMap<>();
        
        for (String[] c : clothes) {
            hm.put(c[1], hm.getOrDefault(c[1], 0) + 1);
        }
        
        int answer = 0;
        for (String k : hm.keySet()) {
            System.out.println(k + " : " + hm.get(k));
            if (answer == 0) {
                answer = hm.get(k) + 1;
                continue;
            }
            answer *= hm.get(k) + 1;
        }
        return answer - 1;
    }
}