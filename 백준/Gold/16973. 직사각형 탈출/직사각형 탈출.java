import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visited;

    private static final int[] DX = {0, 0, -1, 1}; // 왼쪽, 오른쪽, 위, 아래
    private static final int[] DY = {-1, 1, 0, 0};

    private static final int[] size = new int[2];
    private static final int[] startPosition = new int[2];
    private static final int[] endPosition = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialize(br);

        int result = BFS(startPosition[0], startPosition[1]);
        bw.write(result + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        size[0] = Integer.parseInt(st.nextToken());
        size[1] = Integer.parseInt(st.nextToken());

        startPosition[0] = Integer.parseInt(st.nextToken());
        startPosition[1] = Integer.parseInt(st.nextToken());

        endPosition[0] = Integer.parseInt(st.nextToken());
        endPosition[1] = Integer.parseInt(st.nextToken());
    }

    private static int BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentCnt = current[2];

            if (currentX == endPosition[0] && currentY == endPosition[1]) {
                return currentCnt;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (noWall(i, nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, currentCnt + 1});
                }
            }


        }
        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= M;
    }

    private static boolean noWall(int idx, int nextX, int nextY) {
        if (idx == 0) { // 왼쪽
            if (nextY < 1) {
                return false;
            }
            for (int i = 0; i < size[0]; i++) {
                if (arr[nextX + i][nextY] == 1) {
                    return false;
                }
            }

        }
        if (idx == 1) { // 오른쪽
            if (nextY + size[1] - 1 > M) {
                return false;
            }
            for (int i = 0; i < size[0]; i++) {
                if (arr[nextX + i][nextY + size[1] - 1] == 1) {
                    return false;
                }
            }

        }
        if (idx == 2) { // 위
            if (nextX < 1) {
                return false;
            }
            for (int i = 0; i < size[1]; i++) {
                if (arr[nextX][nextY + i] == 1) {
                    return false;
                }
            }
        }
        if (idx == 3) { // 아래
            if (nextX + size[0] - 1 > N) {
                return false;
            }
            for (int i = 0; i < size[1]; i++) {
                if (arr[nextX + size[0] - 1][nextY + i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}