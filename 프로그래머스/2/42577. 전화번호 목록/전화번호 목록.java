import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> hs = new HashSet<>();
        for (String pn : phone_book) {
            hs.add(pn);
        }
        for (String pn : phone_book) {
            for (int i = 1; i < pn.length(); i++) {
                if (hs.contains(pn.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}