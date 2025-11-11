import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = 0;
        long r = (long) n * times[times.length - 1];
        
        long answer = r;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (isPossible(mid, n, times)) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
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