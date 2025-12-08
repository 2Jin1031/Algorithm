import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;

    private static int[] DX = {0, 1, 0, -1};
    private static int[] DY = {1, 0, -1, 0};
    private static final int[][][] DIR_CASES = {
        {}, 
        {
                {0}, {1}, {2}, {3}
        },

        {
                {0, 2},
                {1, 3}
        },
        {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0}
        },
        {
                {0, 1, 2},
                {1, 2, 3},
                {2, 3, 0},
                {3, 0, 1}
        },
        {
                {0, 1, 2, 3}
        }
};
    private static int cctvCnt;
    private static int[][] cctvs;
    private static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        ans = N * M;
        
        cctvs = new int[9][3];
        int cctvIdx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= arr[i][j] && arr[i][j] <= 5) { // cctv라면
                    cctvs[cctvIdx][0] = arr[i][j];
                    cctvs[cctvIdx][1] = i;
                    cctvs[cctvIdx][2] = j;
                    cctvIdx++;
                }
            }
        }
        cctvCnt = cctvIdx;

        dfs(0, arr);
        System.out.println(ans);
        
    }

    private static void dfs(int idx, int[][] map) {
        if (idx == cctvCnt) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) cnt++;
                }
            }
            ans = Math.min(ans, cnt);
            return;
        }
    
        int type = cctvs[idx][0];
        int x = cctvs[idx][1];
        int y = cctvs[idx][2];
    
        for (int[] dirs : DIR_CASES[type]) {
            List<int[]> modified = new ArrayList<>();
    
            for (int d : dirs) {
                paint(map, x, y, d, modified);
            }
    
            dfs(idx + 1, map);
    
            for (int[] pos : modified) {
                int px = pos[0];
                int py = pos[1];
                map[px][py] = 0;
            }
        }
    }

    private static void paint(int[][] map, int sx, int sy, int dir, List<int[]> modified) {
        int nx = sx + DX[dir];
        int ny = sy + DY[dir];
    
        while (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 6) { // 6 = 벽
            if (map[nx][ny] == 0) {
                map[nx][ny] = -1;
                modified.add(new int[]{nx, ny});
            }
            nx += DX[dir];
            ny += DY[dir];
        }
    }
}