class Solution {

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int n, int sum) {
        if (n == numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        return dfs(numbers, target, n + 1, sum + numbers[n]) + dfs(numbers, target, n + 1, sum - numbers[n]);
    }
}