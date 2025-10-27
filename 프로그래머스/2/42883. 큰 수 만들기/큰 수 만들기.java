import java.util.*;

class Solution {
    private String strNum;
    StringBuilder sb;
    int kRemain;
    
    public String solution(String number, int k) {
        
        strNum = number;
        sb = new StringBuilder();
        kRemain = number.length() - k;
        
        while (kRemain > 0) {
            getMaxNum();
            kRemain--;
        }
        
        return sb.toString();
    }
    
    // number[:-(k-1)] 에서 최댓값 구하기
    private void getMaxNum() {
        String target = strNum.substring(0, strNum.length() - kRemain + 1);
        int maxIdx = 0;
        int maxNum = target.charAt(0) - '0';
        
        for (int i = 1; i < target.length(); i++) {
            int digit = target.charAt(i) - '0';
            if (maxNum < digit) {
                maxIdx = i;
                maxNum = digit;
            }
        }
        
        sb.append(maxNum);
        strNum = strNum.substring(maxIdx + 1, strNum.length());
    }
}