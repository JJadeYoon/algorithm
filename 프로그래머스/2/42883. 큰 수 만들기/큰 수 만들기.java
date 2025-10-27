import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!st.isEmpty() && st.peek() < c && k-- > 0) {
                st.pop();
            }
            st.push(c);
        }
        
        for (int i = 0; i < result.length; i++) {
            result[i] = st.get(i);
        }
        
        return new String(result);
    }
}