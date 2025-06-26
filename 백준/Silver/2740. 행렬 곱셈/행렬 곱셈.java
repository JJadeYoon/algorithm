import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] vectorNM = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                vectorNM[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] vectorMK = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                vectorMK[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int temp = 0;
                for (int l = 0; l < m; l++) {
                    temp += vectorNM[i][l] * vectorMK[l][j];
                }
                answer[i][j] = temp;
            }
        }

        StringBuilder answerSB = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                answerSB.append(answer[i][j]);
                if (j != k - 1) {
                    answerSB.append(" ");
                }
            }
            if (i != n - 1) {
                answerSB.append("\n");
            }
        }

        bw.write(answerSB.toString());
        bw.flush();
    }
}