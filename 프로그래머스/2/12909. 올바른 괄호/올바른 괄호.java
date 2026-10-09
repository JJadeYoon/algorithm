import java.util.*;

class Solution {
    boolean solution(String s) {
        List<Character> al = new ArrayList<>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            if (al.isEmpty()) {
                al.add(s.charAt(i));
                continue;
            }
            
            if (s.charAt(i) == ')') {
                al.removeLast();
            } else {
                al.add(s.charAt(i));
            }
        }
        
        return al.isEmpty() ? true : false;
    }
}