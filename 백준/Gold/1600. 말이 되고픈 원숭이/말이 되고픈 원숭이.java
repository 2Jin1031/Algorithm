import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int K, W, H;
    private static int[][] map;
    private static boolean[][][] visited;

    private final static int[] HORSE_DX = {-2, -2, -1, -1, 1, 1, 2, 2};
    private final static int[] HORSE_DY = {-1, 1, -2, 2, -2, 2, -1, 1};

    private final static int[] MONKEY_DX = {-1, 1, 0, 0};
    private final static int[] MONKEY_DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int result = bfs(new int[]{0, 0});

        bw.write(result == Integer.MAX_VALUE ? "-1" : String.valueOf(result));
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int bfs(int[] startPosition) {
        Queue<int[]> queue = new LinkedList<>();
        int[][][] distance = new int[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(distance[i][j], Integer.MAX_VALUE);
            }
        }

        int[] start = new int[]{startPosition[0], startPosition[1], 0};
        queue.add(start);
        distance[startPosition[0]][startPosition[1]][0] = 0;
        visited[startPosition[0]][startPosition[1]][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int loopCount = current[2];

            if (currentX == H - 1 && currentY == W - 1) {
                return distance[currentX][currentY][loopCount];
            }

            for (int i = 0; i < 4; i++) {
                int nx = currentX + MONKEY_DX[i];
                int ny = currentY + MONKEY_DY[i];

                if (isValidCoordinate(nx, ny) && map[nx][ny] != 1 && !visited[nx][ny][loopCount]) {
                    visited[nx][ny][loopCount] = true;
                    distance[nx][ny][loopCount] = distance[currentX][currentY][loopCount] + 1;
                    queue.add(new int[]{nx, ny, loopCount});
                }
            }

            if (loopCount < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = currentX + HORSE_DX[i];
                    int ny = currentY + HORSE_DY[i];

                    if (isValidCoordinate(nx, ny) && map[nx][ny] != 1 && !visited[nx][ny][loopCount + 1]) {
                        visited[nx][ny][loopCount + 1] = true;
                        distance[nx][ny][loopCount + 1] = distance[currentX][currentY][loopCount] + 1;
                        queue.add(new int[]{nx, ny, loopCount + 1});
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && y >= 0 && x < H && y < W;
    }
}