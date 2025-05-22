import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hm = new HashMap<>();
        for (String p : participant) {
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            hm.put(c, hm.getOrDefault(c, 0) - 1);
        }
        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            if (e.getValue() > 0) {
                return e.getKey();
            }
        }
        return "";
    }
}