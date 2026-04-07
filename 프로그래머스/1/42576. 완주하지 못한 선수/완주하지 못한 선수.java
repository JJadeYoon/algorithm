import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hm = new HashMap<>();
        
        for (String p : participant) {
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            hm.put(c, hm.get(c) - 1);
        }
        
        for (String s : hm.keySet()) {
            int v = hm.get(s);
            if (v > 0) {
                return s;
            }
        }
        
        return "";
    }
}