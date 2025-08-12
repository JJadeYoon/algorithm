import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        for (int i : arr) {
            int pos = Collections.binarySearch(lis, i);

            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (lis.size() == pos) {
                lis.add(i);
            } else {
                lis.set(pos, i);
            }
        }

        System.out.print(lis.size());
    }
}