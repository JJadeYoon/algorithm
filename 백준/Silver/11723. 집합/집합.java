import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int m = Integer.parseInt(br.readLine());
        int s = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            int value;
            switch (comm) {
                case "add":
                    value = Integer.parseInt(st.nextToken());
                    s |= 1 << (value - 1);
                    break;
                case "remove":
                    value = Integer.parseInt(st.nextToken());
                    s &= ~(1 << (value - 1));
                    break;
                case "check":
                    value = Integer.parseInt(st.nextToken());
                    if ((s & (1 << (value - 1))) > 0) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    value = Integer.parseInt(st.nextToken());
                    s ^= 1 << (value) - 1;
                    break;
                case "all":
                    s = (1 << 20) - 1;
                    break;
                default:
                    s = 0;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}