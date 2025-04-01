import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> lostList = new ArrayList<>();
        for (int l : lost) {
            lostList.add(l);
        }
        List<Integer> reserveList = new ArrayList<>();
        for (int r : reserve) {
            reserveList.add(r);
        }
        
        for (int i = 1; i < n + 1; i++) {
            if (!lostList.contains(i)) {
                answer++;
            } else {
                if (reserveList.contains(i)) {
                    answer++;
                    lostList.remove(Integer.valueOf(i));
                    reserveList.remove(Integer.valueOf(i));
                }
            }
        }

        for (int i = 0; i < lostList.size(); i++) {
            int l = lostList.get(i);
            if (reserveList.contains(l - 1)) {
                reserveList.remove(Integer.valueOf(l - 1));
                answer++;
            } else if (reserveList.contains(l + 1)) {
                reserveList.remove(Integer.valueOf(l + 1));
                answer++;
            } 
        }
        
        return answer;
    }
}