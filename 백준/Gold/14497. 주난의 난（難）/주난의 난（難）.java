import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static Character[][] arr;
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

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startPosition[0] = Integer.parseInt(st.nextToken()) - 1;
        startPosition[1] = Integer.parseInt(st.nextToken()) - 1;

        endPosition[0] = Integer.parseInt(st.nextToken()) - 1;
        endPosition[1] = Integer.parseInt(st.nextToken()) - 1;

        arr = new Character[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
    }

    private static int BFS(int startX, int startY) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
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
                    if (arr[nextX][nextY] == '0') {
                        queue.offer(new int[]{nextX, nextY, usedTime});
                        visited[nextX][nextY] = true;
                    } else if (arr[nextX][nextY] == '1' || arr[nextX][nextY] == '#') {
                        queue.offer(new int[]{nextX, nextY, usedTime + 1});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M;
    }
}