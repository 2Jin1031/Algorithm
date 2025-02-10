import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] map;

    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int result = dijkstra(0, 0);
        System.out.println(result);
    }

    private static int dijkstra(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] broken = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(broken[i], Integer.MAX_VALUE);
        }
        broken[startX][startY] = 0;

        queue.offer(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isCoordinate(nextX, nextY) && broken[nextX][nextY] > broken[currentX][currentY] + map[nextX][nextY]) {
                    broken[nextX][nextY] = broken[currentX][currentY] + map[nextX][nextY];
                    queue.offer(new int[]{nextX, nextY});
                }
            }

        }
        return broken[N - 1][M - 1];
    }

    private static boolean isCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M;
    }
}