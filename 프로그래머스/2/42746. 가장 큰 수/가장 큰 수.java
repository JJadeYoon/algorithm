import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] stringNumbers = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(stringNumbers, (a, b) ->
                        Integer.parseInt(b + a) - Integer.parseInt(a + b)
                   );
        
        if (stringNumbers[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : stringNumbers) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}