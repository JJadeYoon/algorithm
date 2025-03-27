import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        // 문자열 연결 결과를 직접 비교
        Arrays.sort(stringNumbers, (a, b) -> (b + a).compareTo(a + b));

        // 모든 값이 0인 경우 처리
        if (stringNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stringNumbers) {
            sb.append(s);
        }
        return sb.toString();
    }
}