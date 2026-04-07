import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> al = new ArrayList<>();
        al.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (al.get(al.size() - 1) == arr[i]) {
                continue;
            }
            al.add(arr[i]);
        }
        
        int s = al.size();
        int[] answer = new int[s];
        for (int i = 0; i < s; i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}