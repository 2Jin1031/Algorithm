import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int N;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = BFS();
            System.out.println(String.format("Problem %d: %d", idx, ans));
            idx++;
        }
    }

    private static int BFS() {
        int[][] minCost = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    minCost[i][j] = Integer.MAX_VALUE;
                }
            }
        minCost[0][0] = arr[0][0];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{minCost[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int currentX = current[1];
            int currentY = current[2];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (!isValidCoordinate(nextX, nextY)) continue;

                int nextCost = cost + arr[nextX][nextY];
                if (nextCost < minCost[nextX][nextY]){
                    minCost[nextX][nextY] = nextCost;
                    pq.offer(new int[]{nextCost, nextX, nextY});
                }
            }
        }
        return minCost[N - 1][N - 1];
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N;
    }
}
