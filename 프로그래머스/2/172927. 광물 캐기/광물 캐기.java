class Solution {
    private int minTotal = Integer.MAX_VALUE;
    private final int[][] tired = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    
    public int solution(int[] picks, String[] minerals) {
        backtrack(picks, 0, minerals, 0);
        return minTotal;
    }
    
    private void backtrack(int[] picks, int idx, String[] minerals, int total) {
        boolean isPickRemain = false;
        for (int p : picks) {
            if (p != 0) {
                isPickRemain = true;
                break;
            }
        }
        if (idx == minerals.length || !isPickRemain) {
            minTotal = Math.min(minTotal, total);
            return;
        }
        
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) {
                continue;
            }
            
            // 5개 or 남은 광물 전부 캘 때까지
            int cnt = 0;
            int temp = total;
            while (cnt < 5 && idx < minerals.length) {
                int mNum = getMineralNum(minerals[idx]);
                total += tired[i][mNum];
                cnt++;
                idx++;
            }
            picks[i]--;
            backtrack(picks, idx, minerals, total);
            
            idx -= cnt;
            picks[i]++;
            total = temp;
        }
    }
    
    private int getMineralNum(String mineral) {
        if (mineral.equals("diamond")) {
            return 0;
        } else if (mineral.equals("iron")) {
            return 1;
        } else {
            return 2;
        }
    }
}