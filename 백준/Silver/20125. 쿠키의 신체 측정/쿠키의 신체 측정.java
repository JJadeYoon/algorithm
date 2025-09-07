import java.io.*;
import java.util.*;

class Main {

    private static final char COOKIE = '*';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        int heartRow = 0;
        int heartCol = 0;
        boolean found = false;

        for (; !found && heartRow < n; heartRow++) {
            for (heartCol = 0; heartCol < n; heartCol++) {
                if (board[heartRow].charAt(heartCol) == COOKIE) {
                    found = true;
                    break;
                }
            }
        }
        System.out.println((heartRow + 1) + " " + (heartCol + 1));

        int leftArmLen = heartCol - board[heartRow].indexOf(COOKIE);
        int rightArmLen = board[heartRow].lastIndexOf(COOKIE) - heartCol;

        int legRowStart = heartRow;
        while (board[legRowStart].charAt(heartCol) == COOKIE) {
            legRowStart++;
        }
        int bodyLen = legRowStart - heartRow - 1;

        int leftLegCol = heartCol - 1;
        int leftLegEnd = legRowStart;
        while (leftLegEnd < n && board[leftLegEnd].charAt(leftLegCol) == COOKIE) {
            leftLegEnd++;
        }
        int leftLegLen = leftLegEnd - legRowStart;

        int rightLegCol = heartCol + 1;
        int rightLegEnd = legRowStart;
        while (rightLegEnd < n && board[rightLegEnd].charAt(rightLegCol) == COOKIE) {
            rightLegEnd++;
        }
        int rightLegLen = rightLegEnd - legRowStart;

        System.out.print(leftArmLen + " " + rightArmLen + " " + bodyLen + " " + leftLegLen + " " + rightLegLen);
    }
}