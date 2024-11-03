import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int row, col;
    private static final int WALL = 1;
    private static final int ITEM = 2;

    private static int N, M;
    private static int T;

    private static int[][] arr;
    private static int[][] timeBoard;
    private static boolean[][][] visited;  // 아이템 획득 상태를 구분하기 위해 3차원 배열로 변경

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        int result = bfs(0, 0);
        bw.write(result == -1 ? "Fail" : String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        initArrSize(N, M);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});  // 마지막 요소는 hasItem 상태를 나타냄
        visited[startX][startY][0] = true;
        timeBoard[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int hasItem = current[2];

            if (timeBoard[currentX][currentY] > T) {
                continue;
            }

            if (currentX == N - 1 && currentY == M - 1) {
                return timeBoard[currentX][currentY];
            }

            for (int i = 0; i < DX.length; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY)) {
                    int nextHasItem = hasItem;

                    // 아이템을 획득했을 경우, hasItem 상태를 변경
                    if (arr[nextX][nextY] == ITEM) {
                        nextHasItem = 1;
                    }

                    // 방문 조건: 아이템 획득 여부와 벽 통과 여부에 따라 처리
                    if (!visited[nextX][nextY][nextHasItem] && (arr[nextX][nextY] != WALL || nextHasItem == 1)) {
                        visited[nextX][nextY][nextHasItem] = true;
                        timeBoard[nextX][nextY] = timeBoard[currentX][currentY] + 1;
                        queue.offer(new int[]{nextX, nextY, nextHasItem});
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }

    private static void initArrSize(int rowSize, int colSize) {
        row = rowSize;
        col = colSize;
        arr = new int[row][col];
        timeBoard = new int[row][col];
        visited = new boolean[row][col][2];  // 3차원 배열 초기화: 아이템 획득 여부 포함

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                timeBoard[i][j] = -1;  // 방문하지 않은 위치를 -1로 초기화
            }
        }
    }
}