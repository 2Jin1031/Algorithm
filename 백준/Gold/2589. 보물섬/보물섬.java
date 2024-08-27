import java.io.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static char[][] map;
    private static boolean[][] visited;

    private static int[] DX = {0, 0, 1, -1};
    private static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    int distance = bfs(i, j);
                    maxDistance = Math.max(maxDistance, distance);
                }
            }
        }

        bw.write(maxDistance + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'W') {
                    visited[i][j] = true;
                }
            }
        }

    }

    private static int bfs(int startX, int startY) {
        boolean[][] localVisited = new boolean[N][M];
        int[][] localDistance = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(visited[i], 0, localVisited[i], 0, M);
            Arrays.fill(localDistance[i], -1);
        }

        Queue<int[]> queue = new java.util.LinkedList<>();
        queue.add(new int[]{startX, startY});
        localVisited[startX][startY] = true;
        localDistance[startX][startY] = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordiate(nextX, nextY) && !localVisited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    localVisited[nextX][nextY] = true;
                    localDistance[nextX][nextY] = localDistance[currentX][currentY] + 1;
                }
            }
        }

        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDistance = Math.max(maxDistance, localDistance[i][j]);
            }
        }
        return maxDistance;
    }

    private static boolean isValidCoordiate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }
}