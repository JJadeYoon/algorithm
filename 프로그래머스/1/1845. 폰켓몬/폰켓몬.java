import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int n : nums) {
            hs.add(n);
        }
        if (nums.length / 2 <= hs.size()) {
            return nums.length / 2;
        } else {
            return hs.size();
        }
    }
}