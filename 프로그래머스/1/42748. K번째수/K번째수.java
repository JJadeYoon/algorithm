import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // System.out.println(array[0]);
        int[] answer = new int[commands.length];
        
        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            int[] slice = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(slice);
            System.out.println(Arrays.toString(slice));
            answer[idx] = slice[k-1]; 
        }
        
        return answer;
    }
}