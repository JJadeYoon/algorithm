import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = Math.min(n, m);
        int r = d * 100 / 2;
        System.out.print(r);
    }
}