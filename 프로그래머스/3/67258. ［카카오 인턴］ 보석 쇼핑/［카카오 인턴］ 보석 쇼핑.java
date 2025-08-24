import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;
        Set<String> hs = new HashSet<>();
        for (String gem : gems) {
            hs.add(gem);
        }
        int m = hs.size();

        Map<String, Integer> hm = new HashMap<>();

        int[] answer = new int[]{1, n};
        
        int start = 0;
        for (int end = 0; end < n; end++) {
            String curr = gems[end];
            int currCnt = hm.getOrDefault(curr, 0);
            hm.put(curr, currCnt + 1);

            if (hm.size() == m) {
                while (hm.size() == m && start < n) {
                    int temp = hm.getOrDefault(gems[start], 0);
                    if (temp <= 1) {
                        hm.remove(gems[start++]);
                    } else {
                        hm.put(gems[start++], temp - 1);
                    }
                }
                if (end + 1 - start < answer[1] - answer[0]) {
                    answer = new int[]{start, end + 1};
                }
                // return new int[]{start + 1, end + 1};
            }
        }

        return answer;
    }
}