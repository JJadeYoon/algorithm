import java.util.*;

class Solution {
    public int solution(String name) {
        char[] target = name.toCharArray();
        int n = target.length;
        
        int ud = 0;
        for (int i = 0; i < n; i++) {
            ud += Math.min(target[i] - 'A', 'Z' - target[i] + 1);
        }
        
        int lr = n - 1;
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            
            while (next < n && target[next] == 'A') {
                next++;
            }
            
            lr = Math.min(lr, i * 2 + n - next);
            lr = Math.min(lr, (n - next) * 2 + i);
        }
        
        int total = ud + lr;
        return total;
    }
}