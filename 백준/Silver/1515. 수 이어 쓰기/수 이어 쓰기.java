import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int inputIndex = 0; // input에서 현재 찾고 있는 문자의 인덱스
        int n = 1;

        while (inputIndex < input.length()) {
            String currentN = String.valueOf(n);

            // 현재 숫자 n의 각 자릿수를 순차적으로 확인
            for (int i = 0; i < currentN.length() && inputIndex < input.length(); i++) {
                if (currentN.charAt(i) == input.charAt(inputIndex)) {
                    inputIndex++;
                }
            }

            n++;
        }

        System.out.print(n - 1); // 마지막에 n이 한 번 더 증가했으므로 1을 빼줌
    }
}