import java.util.*;
import java.util.Map.Entry;

class Solution {
    
    String[] answer;

    private static final String BEGIN = "ICN";

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (t1, t2) -> {
            return t1[1].compareTo(t2[1]);
        });
        
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                boolean[] visited = new boolean[tickets.length];
                visited[i] = true;
                List<String> path = new ArrayList<>();
                path.add(tickets[i][0]);
                path.add(tickets[i][1]);
                if (dfs(tickets, visited, path)) {
                    return answer;
                }
            }
        }

        return new String[]{};
    }
    
    private boolean dfs(String[][] tickets, boolean[] visited, List<String> path) {
        if (path.size() == tickets.length + 1) {
            answer = path.toArray(new String[path.size()]);
            return true;
        }
        
        String curr = path.get(path.size() - 1);
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (!tickets[i][0].equals(curr)) {
                continue;
            }
            
            path.add(tickets[i][1]);
            visited[i] = true;
            
            if (dfs(tickets, visited, path)) {
                return true;
            }
            
            path.remove(path.size() - 1);
            visited[i] = false;
        }
        
        return false;
    }
}