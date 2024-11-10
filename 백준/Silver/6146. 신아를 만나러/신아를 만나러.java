import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static boolean[][] visited;
    private static int[][] distance;

    private static int[] endPosition;

    private static final int[] DX = {1, 0, 0, -1};
    private static final int[] DY = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        int result = bfs(500, 500);
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        endPosition = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        endPosition[0] = Integer.parseInt(st.nextToken()) + 500;
        endPosition[1] = Integer.parseInt(st.nextToken()) + 500;
        int positionCount = Integer.parseInt(st.nextToken());

        visited = new boolean[1001][1001];
        distance = new int[1001][1001];

        for (int i = 0; i < positionCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 500;
            int y = Integer.parseInt(st.nextToken()) + 500;
            visited[x][y] = true;
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

            if (currentX == endPosition[0] && currentY == endPosition[1]) {
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
        return nextX >= 0 && nextY >= 0 && nextX < 1001 && nextY < 1001;
    }
}