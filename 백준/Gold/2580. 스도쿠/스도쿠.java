import java.io.*;
import java.util.*;

public class Main {

    private static int[][] arr = new int[9][9];
    private static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int count = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }

        backtracking(arr, count, 0, 0, 0);
    }

    private static void backtracking(int[][] arr, int count, int idx, int currentX, int currentY) {
        if (flag || !isValidValue(arr, currentX, currentY)) {
            return;
        }

        if (count == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            flag = true;
            return;
        }

        int startX = idx / 9;
        int startY = idx % 9;

        for (int i = startX; i < 9; i++) {
            for (int j = (i == startX ? startY : 0); j < 9; j++) {
                if (arr[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        arr[i][j] = k;

                        if (isValidValue(arr, i, j)) {
                            int nextIdx = i * 9 + j + 1;
                            backtracking(arr, count - 1, nextIdx, i, j);
                        }

                        if (flag) return ;
                        arr[i][j] = 0;
                    }
                    return;
                }
            }
        }
    }

    private static boolean isValidValue(int[][] arr, int currentX, int currentY) {
        int val = arr[currentX][currentY];
        if (val == 0) {
            return true;
        }

        for (int j = 0; j < 9; j++) {
            if (j == currentY) continue;
            if (arr[currentX][j] == val) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (i == currentX) continue;
            if (arr[i][currentY] == val) return false;
        }

        int startX = (currentX / 3) * 3;
        int startY = (currentY / 3) * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (i == currentX && j == currentY) continue;
                if (arr[i][j] == val) return false;
            }
        }

        return true;
    }
}