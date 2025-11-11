class Solution {
    
    private int answer = 0;
    
    public int solution(int n) {
        int[] visited = new int[n]; // i번째 행에 놓인 말의 컬럼 인덱스
        backtrack(visited, 0);
        
        return answer;
    }
    
    // idx: 현재 방문 중인 행의 인덱스
    private void backtrack(int[] visited, int idx) {
        int n = visited.length;
        
        if (idx == n) {
            answer++;
            return;
        }
        
        for (int j = 0; j < n; j++) { // idx 행의 j 컬럼 확인
            boolean isValid = true;
            for (int i = 0; i < idx; i++) { // i 행의 공격 가능 확인
                // 같은 컬럼 확인
                if (j == visited[i]) {
                    isValid = false;
                    break;
                }
                // 대각선 확인
                if ((idx - i) == Math.abs(j - visited[i])) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                visited[idx] = j;
                backtrack(visited, idx + 1);
            }
        }
    }
}