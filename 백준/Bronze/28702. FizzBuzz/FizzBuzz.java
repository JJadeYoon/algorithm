import java.io.*;
import java.util.*;

public class Main {
    private static final int TEST_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isMultipleOfThree = false;
        boolean isMultipleOfFive = false;
        int num = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            String input = br.readLine();
            if (!(input.equals("Fizz") || input.equals("Buzz") || input.equals("FizzBuzz"))) {
                num = Integer.parseInt(input);
                num += 3 - i;
                if (num % 3 == 0) {
                    isMultipleOfThree = true;
                }
                if (num % 5 == 0) {
                    isMultipleOfFive = true;
                }
                break;
            }
        }

        String answer;
        if (isMultipleOfThree && isMultipleOfFive) {
            answer = "FizzBuzz";
        } else if (isMultipleOfThree) {
            answer = "Fizz";
        } else if (isMultipleOfFive) {
            answer = "Buzz";
        } else {
            answer = String.valueOf(num);
        }
        System.out.print(answer);
    }
}