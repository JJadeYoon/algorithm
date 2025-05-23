import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNumbers, (a, b) -> 
                        Integer.parseInt(b + a) - Integer.parseInt(a + b)
                   );
        
        if (strNumbers[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : strNumbers) {
            sb.append(s);
        }
        return sb.toString();
    }
}