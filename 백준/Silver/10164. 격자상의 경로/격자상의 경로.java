import java.io.*;
import java.util.*;
import java.util.stream.DoubleStream;

public class Main {
    private static int N, M, K;
    private static int[][] arr;

    private static int[][] load;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        load = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                arr[i][j] = i * M + j;
            }
        }


        int cnt1 = cntLoad(1, K);
        int cnt2 = cntLoad(K, N * M);

        bw.write(cnt1 * cnt2 + "\n");

        bw.close();
        br.close();
    }

    private static int cntLoad(int startValue, int endValue) {
        int startX = findX(startValue);
        int startY = findY(startValue);

        int endX = findX(endValue);
        int endY = findY(endValue);

        load[startX][startY] = 1;

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (i == startX && j == startY) {
                    continue;
                }
                load[i][j] = load[i - 1][j] + load[i][j - 1];
            }
        }
        
        return load[endX][endY];
    }

    private static int findX(int value) {
        return value / M + (value % M == 0 ? 0 : 1);
    }

    private static int findY(int value) {
        return value % M + (value % M == 0 ? M : 0);
    }
}