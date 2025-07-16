import java.io.*;

public class Main {

    private static final int R_VALUE = 31;
    private static final int M_VALUE = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        char[] target = br.readLine().toCharArray();

        int answer = 0;
        for (int i = 0; i < l; i++) {
            int intValue = (int) target[i] - (int) 'a' + 1;
            answer += intValue * power(R_VALUE, i) % M_VALUE;
        }
        System.out.print(answer);
    }

    private static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
}