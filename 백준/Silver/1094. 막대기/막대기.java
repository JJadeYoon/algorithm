import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 64;
        while (count != n) {
            if (count > n) {
                count -= getMinSize(count) / 2;
            } else {
                count += getMinSize(count) / 2;
            }
        }
        System.out.print(countUsed(count));
    }

    private static int countUsed(int n) {
        int count = 0;
        int mask = 1;
        while (mask <= 64) {
            if ((mask & n) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }

    private static int getMinSize(int n) {
        int minSize = 1;
        while (minSize < n) {
            if ((n & minSize) > 0) {
                break;
            }
            minSize = minSize << 1;
        }
        return minSize;
    }
}