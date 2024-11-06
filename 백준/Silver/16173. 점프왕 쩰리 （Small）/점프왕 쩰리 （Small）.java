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

    private static final int[] DX = {1, 0};
    private static final int[] DY = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        bfs(0, 0);

        bw.write(visited[N - 1][N - 1] ? "HaruHaru" : "Hing");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int value = arr[currentX][currentY];

            for (int i = 0; i < 2; i++) {
                int nextX = currentX + DX[i] * value;
                int nextY = currentY + DY[i] * value;

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < N;
    }
}