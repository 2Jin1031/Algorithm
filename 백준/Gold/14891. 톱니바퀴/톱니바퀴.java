import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static int[][] arr;
    private static int[] topIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. input
        arr = new int[5][8];
        topIdx = new int[5];
        for (int i = 1; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = arr[i][j] = input.charAt(j) - '0';
            }
        }
        
        int K = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < K; loop++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int turn = Integer.parseInt(st.nextToken());
            moveWheel(idx, turn);
        }

        int baseScore = 1;
        int sum = 0;
        for (int i = 1; i < 5; i++, baseScore *= 2) {
            if (arr[i][topIdx[i]] == 1) {
                sum += baseScore;
            }
        }

        System.out.println(sum);
    }

    private static void moveWheel(int idx, int turn) {
        int[] turnStorage = new int[5];
        turnStorage[idx] = turn;
    
        // left
        int dir = turn;
        for (int i = idx - 1; i >= 1; i--) {
            int right = findRightIdxByTopIdx(i);
            int left = findLeftIdxByTopIdx(i + 1);
            if (arr[i][right] == arr[i + 1][left]) break;
            dir = changeTurnDirection(dir);
            turnStorage[i] = dir;
        }
    
        // right
        dir = turn;
        for (int i = idx + 1; i <= 4; i++) {
            int left = findLeftIdxByTopIdx(i);
            int right = findRightIdxByTopIdx(i - 1);
            if (arr[i][left] == arr[i - 1][right]) break;
            dir = changeTurnDirection(dir);
            turnStorage[i] = dir;
        }
    
        // turn
        for (int i = 1; i <= 4; i++) {
            if (turnStorage[i] == 0) continue;
            topIdx[i] = (topIdx[i] + 8 + changeTurnDirection(turnStorage[i])) % 8;
        }
    }

    private static int changeTurnDirection(int turn) {
        return turn == 1 ? -1 : 1;
    }

    private static int findLeftIdxByTopIdx(int i) {
        return (topIdx[i] + 6) % 8;
    }

    private static int findRightIdxByTopIdx(int i) {
        return (topIdx[i] + 2) % 8;
    }
}