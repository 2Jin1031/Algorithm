import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, K;

    private static Character[][] arr;
    private static boolean[][][] visited;

    private static final int[] DX = {0, 0, 1, -1}; // 델타 탐색
    private static final int[] DY = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialize(br);
        int result = BFS(0, 0);

        bw.write(result == -1 ? "-1" : String.valueOf(result + 1));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new Character[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == '1') {
                    visited[i][j][0] = true;
                }

            }
        }
    }

    private static int BFS(int startX, int startY) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[]{startX, startY, 0, 0, 0}); // x, y, usedTime, usedK, 낮밤: 0 낮, 1 밤
        visited[startX][startY][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int usedTime = current[2];
            int usedK = current[3];
            int dayNight = current[4];

            if (currentX == N - 1 && currentY == M - 1) {
                return usedTime;
            }

            for (int k = 0; k < 4; k++) {
                int nextX = currentX + DX[k];
                int nextY = currentY + DY[k];

                if (isValidCoordinate(nextX, nextY)) {
                    if (arr[nextX][nextY] == '1' && usedK < K && !visited[nextX][nextY][usedK + 1]) {
                        visited[nextX][nextY][usedK + 1] = true;
                        if (dayNight == 0) { // 낮
                            queue.offer(new int[]{nextX, nextY, usedTime + 1, usedK + 1, 1});
                        } else if (dayNight == 1) { // 밤
                            queue.offer(new int[]{nextX, nextY, usedTime + 2, usedK + 1, 1});
                        }
                    } else if (arr[nextX][nextY] == '0' && !visited[nextX][nextY][usedK]) {
                        visited[nextX][nextY][usedK] = true;
                        if (dayNight == 0) { // 낮
                            queue.offer(new int[]{nextX, nextY, usedTime + 1, usedK, 1});
                        } else if (dayNight == 1) { // 밤
                            queue.offer(new int[]{nextX, nextY, usedTime + 1, usedK, 0});
                        }
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
