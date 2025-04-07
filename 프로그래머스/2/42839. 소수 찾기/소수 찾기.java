import java.util.*;

class Solution {
    public int solution(String numbers) {
        int maxNum = 1;
        for (int i = 0; i < numbers.length(); i++) {
            maxNum *= 10;
        }
        maxNum -= 1;

        boolean[] isPrimeNumber = new boolean[maxNum + 1];
        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;
        for (int i = 2; i * i <= maxNum; i++) {
            if (isPrimeNumber[i]) {
                for (int j = i * i; j <= maxNum; j += i){
                    isPrimeNumber[j] = false;
                }
            }
        }
        
        int answer = 0;
        Set<Integer> hs = new HashSet<>();
        for (int i = 1; i <= numbers.length(); i++) {
            generatePermutationsOfLength(numbers, i, new boolean[numbers.length()], new StringBuilder(), hs);
        }

        for (int h : hs) {
            if (isPrimeNumber[h]) {
                System.out.println(h);
                answer++;
            }
        }

        return answer;
    }

    private void generatePermutationsOfLength(String str, int len, boolean[] used, StringBuilder current, Set<Integer> result) {
        if (current.length() == len) {
            result.add(Integer.parseInt(current.toString()));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                current.append(str.charAt(i));

                generatePermutationsOfLength(str, len, used, current, result);

                // 백트래킹
                current.deleteCharAt(current.length() - 1);
                used[i] = false;
            }
        }
    }
}