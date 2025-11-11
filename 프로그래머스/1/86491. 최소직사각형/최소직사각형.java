import java.util.*;

class Solution {
    // 명함 정렬
    /*
    50 60
    30 70
    30 60
    40 80
    */
    public int solution(int[][] sizes) {
        for (int[] s : sizes) {
            Arrays.sort(s);
        }
        
        int w = sizes[0][0];
        int h = sizes[0][1];
        for (int i = 1; i < sizes.length; i++) {
            w = Math.max(w, sizes[i][0]);
            h = Math.max(h, sizes[i][1]);
        }
        
        return w * h;
    }
}