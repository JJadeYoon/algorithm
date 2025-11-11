import java.util.*;

class Solution {
    
    private Set<Integer> hs = new HashSet<>();
    
    public int solution(String numbers) {
        backtrack(numbers, "", new boolean[numbers.length()]);
        
        int answer = 0;
        for (int i : hs) {
            if (isPrime(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void backtrack(String str, String current, boolean[] visited) {
        // 현재까지 만든 숫자가 있으면 Set에 추가
        if (!current.isEmpty()) {
            hs.add(Integer.parseInt(current));
        }
        
        // 모든 위치의 숫자를 시도
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(str, current + str.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}