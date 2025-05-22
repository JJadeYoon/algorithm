import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int n : nums) {
            hs.add(n);
        }
        int total = nums.length;
        if (total / 2 > hs.size()) {
            return hs.size();
        } else {
            return total / 2;
        }
    }
}