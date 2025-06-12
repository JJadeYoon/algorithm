import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        Arrays.sort(sArr, (a, b) -> (Integer.valueOf(a) - Integer.valueOf(b)));
        String answer = sArr[0] + " " + sArr[sArr.length - 1];
        return answer;
    }
}