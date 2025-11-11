import java.util.*;

class Solution {
    
    private Set<Integer> hs = new HashSet<>();
    List<String> arr = new ArrayList<>();
    
    public int solution(String numbers) {
        backtrack(numbers, "", 0, new boolean[numbers.length()]);
        System.out.println(hs);
        
        if (hs.contains(0)) {
            hs.remove(0);
        }
        if (hs.contains(1)) {
            hs.remove(1);
        }
        
        int answer = 0;
        for (int i : hs) {
            if (isPrime(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void backtrack(String numbers, String cur, int cnt, boolean[] visited) {
        if (cnt == numbers.length()) {
            if (cur.length() > 0) {
                hs.add(Integer.parseInt(cur));   
            }
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }
            backtrack(numbers, cur, cnt + 1, visited);
            visited[i] = true;
            backtrack(numbers, cur + numbers.charAt(i), cnt + 1, visited);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}