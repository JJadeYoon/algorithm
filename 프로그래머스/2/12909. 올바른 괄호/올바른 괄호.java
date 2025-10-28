import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else if (!st.isEmpty()){
                st.pop();
            } else {
                return false;
            }
        }

        return st.isEmpty();
    }
}