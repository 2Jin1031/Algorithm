import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] arr;
    private static boolean[][] visited;

    private static int[] startPosition;
    private static int[] endPosition;

    private static final int[] DX = {-2, -2, 0, 0, 2, 2};
    private static final int[] DY = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        bfs(startPosition[0], startPosition[1]);

        bw.write(arr[endPosition[0]][endPosition[1]] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        startPosition = new int[2];
        endPosition = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        startPosition[0] = Integer.parseInt(st.nextToken());
        startPosition[1] = Integer.parseInt(st.nextToken());
        endPosition[0] = Integer.parseInt(st.nextToken());
        endPosition[1] = Integer.parseInt(st.nextToken());

        arr[endPosition[0]][endPosition[1]] = -1;
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if (currentX == endPosition[0] && currentY == endPosition[1]) {
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    arr[nextX][nextY] = arr[currentX][currentY] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    private static boolean isValidCoordinate(int currentX, int currentY) {
        return currentX >= 0 && currentX < N && currentY >= 0 && currentY < N;
    }
}
