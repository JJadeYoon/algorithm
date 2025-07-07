import java.io.*;
import java.util.*;

public class Main {
    private static int headRow;
    private static int headCol;

    private static class Turn {
        int time;
        String turnDir;

        Turn(int time, String turnDir) {
            this.time = time;
            this.turnDir = turnDir;
        }
    }

    private static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n, k 입력
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // 사과 위치 입력
        boolean[][] apples = new boolean[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int tempN = Integer.parseInt(st.nextToken());
            int tempK = Integer.parseInt(st.nextToken());
            apples[tempN][tempK] = true;
        }

        // 방향 변환 정보 입력
        int l = Integer.parseInt(br.readLine());
        Queue<Turn> turnQueue = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int tempTime = Integer.parseInt(st.nextToken());
            String tempDir = st.nextToken();
            turnQueue.offer(new Turn(tempTime, tempDir));
        }

        // 뱀
        headRow = 1;
        headCol = 1;
        Deque<Point> snake = new LinkedList<>();
        snake.offerFirst(new Point(headRow, headCol));
        boolean[][] snakeMap = new boolean[n + 1][n + 1];
        snakeMap[headRow][headCol] = true;

        int time = 0;
        String dir = "r";
        while (true) {
            time++;

            // 이동
            if (move(snake, snakeMap, dir)) { // 이동 가능한 경우
                if (!apples[headRow][headCol]) { // 사과를 먹지 못하는 경우
                    Point tailPoint = snake.pollLast();
                    snakeMap[tailPoint.row][tailPoint.col] = false;
                } else {
                    apples[headRow][headCol] = false;
                }
            } else { // 이동하지 못하는 경우 종료
                break;
            }

            // 방향 전환
            if (!turnQueue.isEmpty()) {
                if (time == turnQueue.peek().time) {
                    dir = changeDir(dir, turnQueue.poll().turnDir);
                }
            }
        }

        System.out.print(time);
    }

    private static boolean isValid(boolean[][] snakeMap, int headRow, int headCol) {
        if (headRow >= 1 && headCol >= 1 && headRow < snakeMap.length && headCol < snakeMap.length) {
            return !snakeMap[headRow][headCol]; // 머리가 몸과 부딪히지 않는 경우 true 반환
        } else { // 벽에 부딪히는 경우
            return false;
        }
    }

    private static String changeDir(String preDir, String turn) {
        switch (preDir) {
            case "r":
                if (turn.equals("D")) {
                    return "d";
                } else {
                    return "u";
                }
            case "l":
                if (turn.equals("D")) {
                    return "u";
                } else {
                    return "d";
                }
            case "u":
                if (turn.equals("D")) {
                    return "r";
                } else {
                    return "l";
                }
            default:
                if (turn.equals("D")) {
                    return "l";
                } else {
                    return "r";
                }
        }
    }

    private static void printSnake(Deque<Point> snake, int n) {
        boolean[][] snakeArr = new boolean[n + 1][n + 1];
        for (Point point : snake) {
            snakeArr[point.row][point.col] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (snakeArr[i][j]) {
                    System.out.print("o ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    private static boolean move(Deque<Point> snake, boolean[][] snakeMap, String dir) {
        int nextRow = headRow;
        int nextCol = headCol;

        switch (dir) {
            case "r":
                nextCol++;
                break;
            case "l":
                nextCol--;
                break;
            case "u":
                nextRow--;
                break;
            default:
                nextRow++;
                break;
        }

        if (isValid(snakeMap, nextRow, nextCol)) {
            snakeMap[nextRow][nextCol] = true;
            snake.offerFirst(new Point(nextRow, nextCol));
            headRow = nextRow;
            headCol = nextCol;
            return true;
        } else {
            return false;
        }
    }
}