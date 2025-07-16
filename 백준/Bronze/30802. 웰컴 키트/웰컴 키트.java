import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] tShirts = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tShirtsUnit = Integer.parseInt(st.nextToken());
        int penUnit = Integer.parseInt(st.nextToken());

        int tShirtBundle = 0;
        for (int tShirt : tShirts) {
            tShirtBundle +=  (int) Math.ceil((double) tShirt / tShirtsUnit);
        }

        int penBundle = n / penUnit;
        int penIndividual = n % penUnit;

        System.out.println(tShirtBundle);
        System.out.print(penBundle + " " + penIndividual);
    }
}