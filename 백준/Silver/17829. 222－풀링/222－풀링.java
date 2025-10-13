import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 1;

        for (int chunk = 1; chunk <= N / 2; chunk <<= 1) {
            int doubleChunk = chunk * 2;
            for (int startX = 0; startX + chunk < N; startX += doubleChunk) {
                for (int startY = 0; startY + chunk < N; startY += doubleChunk) {
                    int[] localArr = new int[4];
                    localArr[0] = arr[startX][startY];
                    localArr[1] = arr[startX + chunk][startY];
                    localArr[2] = arr[startX][startY + chunk];
                    localArr[3] = arr[startX + chunk][startY + chunk];

                    Arrays.sort(localArr);

                    arr[startX][startY] = localArr[2];
                }
            }
        }
        System.out.println(arr[0][0]);
    }
}