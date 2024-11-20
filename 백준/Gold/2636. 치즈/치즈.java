import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int cheeseCount = 0;

    private static ArrayList<int[]> edgePositions = new ArrayList<>();

    private static int[] DX = {0, 0, 1, -1};
    private static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialize(br);
        ArrayList<int[]> firstEdgePositions = new ArrayList<>();
        firstEdgePositions.add(new int[]{0, 0});
        BFS(firstEdgePositions); // 가장자리에 있는 치즈들 BFS로 탐색
        int usedTime = 1;
        while(true) {
            edgeCheck(); // 가장자리에 있는 치즈들 찾아서 edgePositions에 넣기
            if (cheeseCount == 0) {
                break;
            }
            BFS(edgePositions); // 가장자리에 있는 치즈들 BFS로 탐색
            usedTime++;
        }

        int remainCheeseCount = edgePositions.size();
        bw.write(usedTime + "\n" + remainCheeseCount + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }
    }

    private static void edgeCheck() {
        edgePositions.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && edgeSurroundingCheck(i, j)) { // 주변이 공기라면
                    edgePositions.add(new int[]{i, j});
                    cheeseCount--;
                }
            }
        }
    }

    private static boolean edgeSurroundingCheck(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nextX = i + DX[k];
            int nextY = j + DY[k];

            if (visited[nextX][nextY]) {
                return true;
            }
        }
        return false;
    }

    private static int BFS(ArrayList<int[]> edgePositions) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] edgePosition : edgePositions) {
            queue.offer(new int[]{edgePosition[0], edgePosition[1]});
            visited[edgePosition[0]][edgePosition[1]] = true;
        }

        while (!queue.isEmpty()) { // 구멍이 뚫렸는 지 파악
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int k = 0; k < 4; k++) {
                int nextX = currentX + DX[k];
                int nextY = currentY + DY[k];

                if (isValidCoordinate(nextX, nextY) && arr[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
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