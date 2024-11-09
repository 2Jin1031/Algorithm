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
    private static int[][] distance;

    private static int[] startPosition;

    private static final int[] DX = {1, 0, 0, -1};
    private static final int[] DY = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        int result = bfs(startPosition[0], startPosition[1]);
        bw.write(result != -1 ? "TAK" + "\n" + result + "\n" : "NIE\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];
        startPosition = new int[2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
                if (arr[i][j] == 1) {
                    visited[i][j] = true;
                }
                if (arr[i][j] == 2) {
                    startPosition[0] = i;
                    startPosition[1] = j;
                }
            }
        }
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if (arr[currentX][currentY] >= 3) {
                return distance[currentX][currentY];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    distance[nextX][nextY] = distance[currentX][currentY] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }
}