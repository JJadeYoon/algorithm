class Solution {
    private int count = 0;

    public int solution(int n) {
        int[] board = new int[n];
        boolean[] visited = new boolean[n];
        backtrack(0, n, board, visited);
        return count;
    }

    private void backtrack(int level, int n, int[] board, boolean[] visited) {
        if (level == n) {
            count++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            
            boolean isValid = true;
            for (int j = 1; j <= level; j++) {
                int temp = level - j;
                if (Math.abs(i - board[temp]) == j) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) {
                continue;
            }

            visited[i] = true;
            board[level] = i;
            backtrack(level + 1, n, board, visited);
            visited[i] = false;
        }
    }
}