import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static int N, M;

    private static boolean[][] visited;

    private static final int[] DX = {0, 0, 1, -1}; // 델타 탐색
    private static final int[] DY = {1, -1, 0, 0};

    private static final int[] startPosition = new int[2];
    private static final int[] endPosition = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialize(br);
        int result = BFS(startPosition[0], startPosition[1]);

        bw.write(result - 1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = 10;
        M = 10;

        Character[][] arr = new Character[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'R') {
                    visited[i][j] = true;
                } else if (arr[i][j] == 'B') {
                    startPosition[0] = i;
                    startPosition[1] = j;
                } else if (arr[i][j] == 'L') {
                    endPosition[0] = i;
                    endPosition[1] = j;
                }
            }

        }
    }

    private static int BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int usedTime = current[2];

            if (currentX == endPosition[0] && currentY == endPosition[1]) {
                return usedTime;
            }

            for (int k = 0; k < 4; k++) {
                int nextX = currentX + DX[k];
                int nextY = currentY + DY[k];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY, usedTime + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M;
    }
}
