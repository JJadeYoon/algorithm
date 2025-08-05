import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = (" " + br.readLine()).toCharArray();
        int n = s1.length;
        char[] s2 = (" " + br.readLine()).toCharArray();
        int m = s2.length;

        int[][] lcs = new int[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (s1[i] == s2[j]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }

        System.out.print(lcs[n - 1][m - 1]);
    }
}