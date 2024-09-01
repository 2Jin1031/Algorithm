import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[][] distance;

    private static Queue<int[]> queue = new LinkedList<>();

    private final static int[] DX = {0, 0, 1, -1, 1, -1, 1, -1};
    private final static int[] DY = {1, -1, 0, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        int maxDistance = BFS();

        bw.write(maxDistance + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }
    }

    private static int BFS() {
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 8; i++) {
                int nextX = x + DX[i];
                int nextY = y + DY[i];

                if (isValidCoordinate(nextX, nextY) && distance[nextX][nextY] == -1) {
                    distance[nextX][nextY] = distance[x][y] + 1;
                    maxDistance = Math.max(maxDistance, distance[nextX][nextY]);
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return maxDistance;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M;
    }
}
