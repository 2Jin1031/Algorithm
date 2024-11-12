import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] arr;
    private static int[][] minConversions;

    private static final int[] DX = {1, 0, 0, -1};
    private static final int[] DY = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        minConversions = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                minConversions[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});
        minConversions[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentConversions = current[2];

            if (currentX == N - 1 && currentY == N - 1) {
                return currentConversions;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY)) {
                    int nextCount = currentConversions + (arr[nextX][nextY] == 0 ? 1 : 0);
                    if (nextCount < minConversions[nextX][nextY]) {
                        minConversions[nextX][nextY] = nextCount;
                        pq.offer(new int[]{nextX, nextY, nextCount});
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < N;
    }
}