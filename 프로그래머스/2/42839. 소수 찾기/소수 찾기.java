import java.util.*; 

class Solution {
    private Set<Integer> hs = new HashSet<>();
    
    public int solution(String numbers) {
        backtrack(numbers, new boolean[numbers.length()], "");
        
        int answer = 0;
        for (int i : hs) {
            if (isPrime(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void backtrack(String numbers, boolean[] visited, String cur) {
        if (cur.length() > 0) {
            hs.add(Integer.parseInt(cur));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backtrack(numbers, visited, cur + numbers.charAt(i));
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}