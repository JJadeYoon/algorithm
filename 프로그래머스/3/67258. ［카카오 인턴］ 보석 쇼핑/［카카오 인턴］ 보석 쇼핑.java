import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        if (gems.length == 1) return new int[]{1, 1};
        
        // 고유한 보석 종류 수 계산
        Set<String> gemTypes = new HashSet<>();
        for (String gem : gems) {
            gemTypes.add(gem);
        }
        int requiredTypes = gemTypes.size();
        
        Map<String, Integer> windowCount = new HashMap<>();
        int minLength = gems.length;
        int resultStart = 0, resultEnd = gems.length - 1;
        
        int start = 0;
        for (int end = 0; end < gems.length; end++) {
            // 윈도우 확장
            String currentGem = gems[end];
            windowCount.put(currentGem, windowCount.getOrDefault(currentGem, 0) + 1);
            
            // 모든 종류가 포함되면 윈도우 축소 시도
            while (windowCount.size() == requiredTypes) {
                int currentLength = end - start + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    resultStart = start;
                    resultEnd = end;
                }
                
                // 윈도우 축소
                String leftGem = gems[start];
                int leftCount = windowCount.get(leftGem) - 1;
                if (leftCount == 0) {
                    windowCount.remove(leftGem);
                } else {
                    windowCount.put(leftGem, leftCount);
                }
                start++;
            }
        }
        
        return new int[]{resultStart + 1, resultEnd + 1};
    }
}