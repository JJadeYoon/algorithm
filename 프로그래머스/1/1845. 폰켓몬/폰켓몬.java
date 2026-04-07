import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        
        Set<Integer> hs = new HashSet<>();
        
        for (int i : nums) {
            hs.add(i);
        }
        
        return n / 2 < hs.size() ? n / 2 : hs.size();
    }
}