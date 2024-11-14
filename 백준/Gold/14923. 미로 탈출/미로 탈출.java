import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] arr;
    private static boolean[][][] visited;

    private static int[] startPosition = new int[2];
    private static int[] endPosition = new int[2];

    private static final int[] DX = {1, 0, 0, -1};
    private static final int[] DY = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);
        int result = BFS(startPosition[0], startPosition[1]);
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2];

        st = new StringTokenizer(br.readLine());
        startPosition[0] = Integer.parseInt(st.nextToken()) - 1;
        startPosition[1] = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        endPosition[0] = Integer.parseInt(st.nextToken()) - 1;
        endPosition[1] = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY][0] = true;

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                int broken = current[2];

                if (currentX == endPosition[0] && currentY == endPosition[1]) {
                    return distance;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = currentX + DX[i];
                    int nextY = currentY + DY[i];

                    if (isValidCoordinate(nextX, nextY)) {
                        if (arr[nextX][nextY] == 1 && broken == 0 && !visited[nextX][nextY][1]) {
                            visited[nextX][nextY][1] = true;
                            queue.offer(new int[]{nextX, nextY, 1});
                        } else if (arr[nextX][nextY] == 0 && !visited[nextX][nextY][broken]) {
                            visited[nextX][nextY][broken] = true;
                            queue.offer(new int[]{nextX, nextY, broken});
                        }
                    }
                }
            }
            distance++;
        }

        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }
}