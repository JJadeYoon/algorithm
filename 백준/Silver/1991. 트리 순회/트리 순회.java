import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] lc;
    private static int[] rc;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        lc = new int[n];
        rc = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
            if (left != '.' - 'A') {
                lc[root] = left;
            }
            if (right != '.' - 'A') {
                rc[root] = right;
            }
        }

        preorder(0);
        bw.write("\n");
        inorder(0);
        bw.write("\n");
        postorder(0);
        bw.flush();
        
        br.close();
        bw.close();
    }

    private static void preorder(int curr) throws Exception {
        bw.write((char)curr + 'A');
        if (lc[curr] != 0) {
            preorder(lc[curr]);
        }
        if (rc[curr] != 0) {
            preorder(rc[curr]);
        }
    }

    private static void inorder(int curr) throws Exception {
        if (lc[curr] != 0) {
            inorder(lc[curr]);
        }
        bw.write((char)curr + 'A');
        if (rc[curr] != 0) {
            inorder(rc[curr]);
        }
    }

    private static void postorder(int curr) throws Exception {
        if (lc[curr] != 0) {
            postorder(lc[curr]);
        }
        if (rc[curr] != 0) {
            postorder(rc[curr]);
        }
        bw.write((char)curr + 'A');
    }
}