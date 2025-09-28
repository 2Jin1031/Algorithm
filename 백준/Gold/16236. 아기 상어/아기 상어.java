import java.io.*;
import java.util.*;

public class Main {

    static final int[] DX = {-1, 0, 1, 0};
    static final int[] DY = {0, -1, 0, 1};

    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int sx = -1, sy = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    sx = i; sy = j;
                    board[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0;
        int time = 0;

        while (true) {
            int[] next = bfsFindNearestFish(sx, sy, size);
            if (next == null) break;

            int nx = next[0], ny = next[1], dist = next[2];
            time += dist;
            eat++;

            board[nx][ny] = 0;
            sx = nx; sy = ny;

            if (eat == size) {
                size++;
                eat = 0;
            }
        }

        System.out.println(time);
    }

    static int[] bfsFindNearestFish(int sx, int sy, int sharkSize) {
        int[][] dist = new int[N][N];
        for (int[] d : dist) Arrays.fill(d, -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;

        int bestDist = Integer.MAX_VALUE;
        int bestX = -1, bestY = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            int cd = dist[x][y];
            if (cd > bestDist) break;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + DX[dir];
                int ny = y + DY[dir];

                if (!in(nx, ny)) continue;
                if (dist[nx][ny] != -1) continue;
                if (board[nx][ny] > sharkSize) continue;

                dist[nx][ny] = cd + 1;

                if (board[nx][ny] != 0 && board[nx][ny] < sharkSize) {
                    if (dist[nx][ny] < bestDist
                            || (dist[nx][ny] == bestDist && (nx < bestX
                            || (nx == bestX && ny < bestY)))) {
                        bestDist = dist[nx][ny];
                        bestX = nx;
                        bestY = ny;
                    }
                }

                q.offer(new int[]{nx, ny});
            }
        }

        if (bestX == -1) return null;
        return new int[]{bestX, bestY, bestDist};
    }

    static boolean in(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}