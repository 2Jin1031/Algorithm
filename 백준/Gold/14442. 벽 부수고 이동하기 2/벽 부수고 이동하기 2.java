import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, K;
    private static int[][] map;

    private final static int[] DX = {0, 0, 1, -1};
    private final static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int minDistance = bfs(0, 0);

        bw.write(minDistance + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});

        int[][][] localVisited = new int[N][M][K + 1];
        localVisited[startX][startY][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int broken = current[2];

            if (currentX == N - 1 && currentY == M - 1) {
                return localVisited[currentX][currentY][broken];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY)) {
                    if (map[nextX][nextY] == 0 && localVisited[nextX][nextY][broken] == 0) {
                        queue.add(new int[]{nextX, nextY, broken});
                        localVisited[nextX][nextY][broken] = localVisited[currentX][currentY][broken] + 1;
                    } else if (map[nextX][nextY] == 1 && broken < K && localVisited[nextX][nextY][broken + 1] == 0) {
                        queue.add(new int[]{nextX, nextY, broken + 1});
                        localVisited[nextX][nextY][broken + 1] = localVisited[currentX][currentY][broken] + 1;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
