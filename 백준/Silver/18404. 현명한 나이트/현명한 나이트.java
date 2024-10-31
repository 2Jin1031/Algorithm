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

    private static int[] startPosition;
    private static int[][] pointPosition;

    private static final int[] DX = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] DY = {-1, 1, -2, +2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        bfs(startPosition[0], startPosition[1]);

        for (int i = 0; i < M; i++) {
            int x = pointPosition[i][0];
            int y = pointPosition[i][1];
            bw.write(arr[x][y] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        startPosition = new int[2];
        pointPosition = new int[M][2];

        st = new StringTokenizer(br.readLine());
        startPosition[0] = Integer.parseInt(st.nextToken());
        startPosition[1] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pointPosition[i][0] = x;
            pointPosition[i][1] = y;
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        arr[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = arr[currentX][currentY] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX > 0 && nextY > 0 && nextX <= N && nextY <= N;
    }
}