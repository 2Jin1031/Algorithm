import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static int[][] arr;
    private static int[] topIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H][W + 1];
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            arr[i][0] = -1;
            for (int j = 1; j < W + 1; j++) {
                if (input.charAt(j - 1) != 'c') {
                    arr[i][j] = -1;
                }
            }
        }

        // logic
        for (int i = 0; i < H; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (arr[i][j - 1] >= 0 && arr[i][j] == -1) {
                    arr[i][j] = arr[i][j - 1] + 1;
                }
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}