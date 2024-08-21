import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[][][] visited;
    private final static int[] DX = {0, 0, 1, -1};
    private final static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int result = bfs(1, 1);
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0}); 
        visited[startX][startY][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int broken = current[2];

            if (currentX == N && currentY == M) {
                return visited[currentX][currentY][broken];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY)) {
                    if (map[nextX][nextY] == 0 && visited[nextX][nextY][broken] == 0) {
                        queue.offer(new int[]{nextX, nextY, broken});
                        visited[nextX][nextY][broken] = visited[currentX][currentY][broken] + 1;
                    }
                    else if (map[nextX][nextY] == 1 && broken == 0) {
                        queue.offer(new int[]{nextX, nextY, 1});
                        visited[nextX][nextY][1] = visited[currentX][currentY][broken] + 1;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 1 && nextY >= 1 && nextX <= N && nextY <= M;
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }
    }
}