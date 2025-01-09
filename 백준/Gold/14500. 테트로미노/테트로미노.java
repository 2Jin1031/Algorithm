import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] DX = {1, -1, 0, 0};
    private static int[] DY = {0, 0, 1, -1};

    private static int maxSum = 0;

    public static void main(String[] args) throws IOException {

        initialize();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;

                handleTShape(i, j);
            }
        }

        System.out.println(maxSum);
    }

    private static void initialize() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

    private static int BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 1, map[startX][startY]});
        visited[startX][startY] = true;

        int localMaxSum = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int size = current[2];
            int sum = current[3];

            if (size == 4) {
                localMaxSum = Math.max(localMaxSum, sum);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];
                if (isCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY, size + 1, sum + map[nextX][nextY]});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return localMaxSum;
    }

    private static void dfs(int currentX, int currentY, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return ;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = currentX + DX[i];
            int nextY = currentY + DY[i];

            if (isCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, depth + 1, sum + map[nextX][nextY]);
                visited[nextX][nextY] = false;
            }
        }

    }

    private static void handleTShape(int currentX, int currentY) {
        int sum = map[currentX][currentY];
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = currentX + DX[i];
            int nextY = currentY + DY[i];

            if (isCoordinate(nextX, nextY)) {
                sum += map[nextX][nextY];
                count++;
            }
        }

        if (count == 4) {
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isCoordinate(nextX, nextY)) {
                    maxSum = Math.max(maxSum, sum - map[nextX][nextY]);
                }
            }
        } else if (count == 3) {
            maxSum = Math.max(maxSum, sum);
        }
    }

    private static boolean isCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M;
    }
}