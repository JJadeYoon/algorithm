import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1;
        long right = (long)times[times.length - 1] * n;
        
        long answer = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPossible(mid, n, times)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean isPossible(long time, int n, int[] times) {
        long total = 0;
        for (int t : times) {
            total += time / t;
        }
        return total >= n;
    }
}