import java.io.*;
import java.util.*;

import static java.lang.Math.max;

public class Main {
    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r][c] = true;
        }

        int[] cnt = {0};

        int maxCnt = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                cnt[0] = 0;
                if (arr[i][j]) {
                    maxCnt = max(maxCnt, DFS(i, j, arr));
                }
            }
        }

        bw.write(maxCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int DFS(int x, int y, boolean[][] arr) {
        int count = 1;
        arr[x][y] = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && arr[nx][ny]) {
                count += DFS(nx, ny, arr);
            }
        }

        return count;
    }
}
