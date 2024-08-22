import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    private final static int[] DX = {0, 0, 1, -1};
    private final static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int year = 0;
        while (true) {
            year++;
            int[][] tempMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tempMap[i][j] = map[i][j];
                }
            }

            bfs(tempMap);

            visited = new boolean[N][M];
            int icebergCount = findIceberg();
            if (icebergCount == 0) {
                bw.write("0\n");
                break;
            } else if (icebergCount >= 2) {
                bw.write(year + "\n");
                break;
            }
        }

        bw.close();
        br.close();
    }

    private static int findIceberg() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    count++;
                    bfsCount(i, j);
                }
            }
        }
        return count;
    }

    private static void bfsCount(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (isValidCoordinate(nx, ny) && !visited[nx][ny] && map[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void bfs(int[][] tempMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int meltCount = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + DX[k];
                        int ny = j + DY[k];

                        if (isValidCoordinate(nx, ny) && map[nx][ny] == 0) {
                            meltCount++;
                        }
                    }

                    tempMap[i][j] = Math.max(0, map[i][j] - meltCount);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.arraycopy(tempMap[i], 0, map[i], 0, M);
        }
    }

    private static boolean isValidCoordinate(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}