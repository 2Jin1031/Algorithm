import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    private final static int[] DX = {0, 1};
    private final static int[] DY = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        boolean possible = BFS();
        bw.write(possible ? "Yes" : "No");

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
    }

    private static boolean BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == N - 1 && y == M - 1) {
                return true;
            }

            for (int i = 0; i < 2; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (isValidCoordinate(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }

    private static boolean isValidCoordinate(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}