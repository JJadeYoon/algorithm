import java.io.*;
import java.util.*;

public class Main {
    public static class Visit {
        int curr;
        int next;
        int count;

        Visit(int curr, int next, int count) {
            this.curr = curr;
            this.next = next;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] relationships = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            relationships[i][0] = Integer.parseInt(temp[0]);
            relationships[i][1] = Integer.parseInt(temp[1]);
        }

        int[] counts = new int[n + 1]; // 1부터 n번을 사용하기 위한 n+1 배열

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                count += countVisit(i, j, relationships, n);
            }
            counts[i] = count;
        }

        // 결과 출력
        int minBacon = n * (n - 1);
        for (int i = 1; i <= n; i++) {
            minBacon = Math.min(minBacon, counts[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (counts[i] == minBacon) {
                bw.write(i + "");
                bw.flush();
                break;
            }
        }
        br.close();
        bw.close();
    }

    private static int countVisit(int person, int target, int[][] relationships, int n) {
        if (person == target) {
            return 0;
        }

        int count = 1;
        int curr = person;
        Queue<Visit> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[person] = true;

        for (int i = 0; i < relationships.length; i++) {
            if (relationships[i][0] == curr) {
                if (relationships[i][1] == target) {
                    return count;
                }
                visited[relationships[i][1]] = true;
                queue.offer(new Visit(relationships[i][0], relationships[i][1], count));
            } else if (relationships[i][1] == curr) {
                if (relationships[i][0] == target) {
                    return count;
                }
                visited[relationships[i][0]] = true;
                queue.offer(new Visit(relationships[i][1], relationships[i][0], count));
            }
        }

        while (!queue.isEmpty()) {
            Visit visit = queue.poll();
            curr = visit.next;
            count = visit.count + 1;
            for (int i = 0; i < relationships.length; i++) {
                if (relationships[i][0] == curr && !visited[relationships[i][1]]) {
                    if (relationships[i][1] == target) {
                        return count;
                    }
                    visited[relationships[i][1]] = true;
                    queue.offer(new Visit(relationships[i][0], relationships[i][1], count));
                } else if (relationships[i][1] == curr && !visited[relationships[i][0]]) {
                    if (relationships[i][0] == target) {
                        return count;
                    }
                    visited[relationships[i][0]] = true;
                    queue.offer(new Visit(relationships[i][1], relationships[i][0], count));
                }
            }
        }

        return -1;
    }
}