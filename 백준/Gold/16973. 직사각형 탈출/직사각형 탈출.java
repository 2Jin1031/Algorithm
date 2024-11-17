import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] grid;
    private static boolean[][] visited;

    private static final int[] DELTA_X = {0, 0, -1, 1};
    private static final int[] DELTA_Y = {-1, 1, 0, 0};

    private static final int[] rectangleSize = new int[2];
    private static final int[] startPosition = new int[2];
    private static final int[] endPosition = new int[2];

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out))) {

            initialize(br);
            int result = findMinimumMoves(startPosition[0], startPosition[1]);
            bw.write(result + "\n");
        }
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        rectangleSize[0] = Integer.parseInt(st.nextToken());
        rectangleSize[1] = Integer.parseInt(st.nextToken());
        startPosition[0] = Integer.parseInt(st.nextToken());
        startPosition[1] = Integer.parseInt(st.nextToken());
        endPosition[0] = Integer.parseInt(st.nextToken());
        endPosition[1] = Integer.parseInt(st.nextToken());
    }

    private static int findMinimumMoves(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int moveCount = current[2];

            if (currentX == endPosition[0] && currentY == endPosition[1]) {
                return moveCount;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DELTA_X[i];
                int nextY = currentY + DELTA_Y[i];

                if (isWithinBounds(nextX, nextY) && canMove(i, nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, moveCount + 1});
                }
            }
        }
        return -1;
    }

    private static boolean isWithinBounds(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }

    private static boolean canMove(int direction, int nextX, int nextY) {
        switch (direction) {
            case 0:
                if (nextY < 1) return false;
                for (int i = 0; i < rectangleSize[0]; i++) {
                    if (grid[nextX + i][nextY] == 1) return false;
                }
                break;
            case 1:
                if (nextY + rectangleSize[1] - 1 > M) return false;
                for (int i = 0; i < rectangleSize[0]; i++) {
                    if (grid[nextX + i][nextY + rectangleSize[1] - 1] == 1) return false;
                }
                break;
            case 2:
                if (nextX < 1) return false;
                for (int i = 0; i < rectangleSize[1]; i++) {
                    if (grid[nextX][nextY + i] == 1) return false;
                }
                break;
            case 3:
                if (nextX + rectangleSize[0] - 1 > N) return false;
                for (int i = 0; i < rectangleSize[1]; i++) {
                    if (grid[nextX + rectangleSize[0] - 1][nextY + i] == 1) return false;
                }
                break;
        }
        return true;
    }
}