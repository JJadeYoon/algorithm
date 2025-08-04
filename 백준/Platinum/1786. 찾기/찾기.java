import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] t = br.readLine().toCharArray();
        int n = t.length;
        char[] p = br.readLine().toCharArray();

        int[] pi = getPi(p);
        int j = 0;
        int count = 0;
        List<Integer> matchIdxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (j > 0 && t[i] != p[j]) {
                j = pi[j - 1];
            }
            if (t[i] == p[j]) {
                if (j == p.length - 1) {
                    matchIdxList.add(i - (p.length - 1));
                    count++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        System.out.println(count);
        StringBuilder sb = new StringBuilder();
        for (Integer i : matchIdxList) {
            sb.append(i + 1).append(' ');
        }
        System.out.print(sb);
    }

    private static int[] getPi(char[] p) {
        int m = p.length;
        int[] pi = new int[m];
        pi[0] = 0;
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = pi[j - 1];
            }
            if (p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}