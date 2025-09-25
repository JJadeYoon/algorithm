class Solution {
    
    private int num = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, target, numbers, 0);
        return num;
    }
    
    private void dfs(int cumm, int target, int[] numbers, int currIdx) {
        if (currIdx == numbers.length) {
            if (cumm == target){
                num++;    
            }
            return;
        }
        
        dfs(cumm + numbers[currIdx], target, numbers, currIdx + 1);
        dfs(cumm - numbers[currIdx], target, numbers, currIdx + 1);
        
        return;
    }
}