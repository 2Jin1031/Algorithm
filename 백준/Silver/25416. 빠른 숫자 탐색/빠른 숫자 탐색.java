import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int row, col;

    private static int[][] arr;
    private static int[][] board;
    private static boolean[][] visited;

    private static int[] startPosition;

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        int result = bfs(startPosition[0], startPosition[1]);
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        initArrSize(5);
        startPosition = new int[2];

        for (int i = 0; i < row; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        startPosition[0] = Integer.parseInt(st.nextToken());
        startPosition[1] = Integer.parseInt(st.nextToken());
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if (arr[currentX][currentY] == 1) {
                return board[currentX][currentY];
            }

            for (int i = 0; i < DX.length; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    board[nextX][nextY] = board[currentX][currentY] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < row && nextY < col;
    }

    private static void initArrSize(int size) {
        initArrSize(size, size);
    }

    private static void initArrSize(int rowSize, int colSize) {
        row = rowSize;
        col = colSize;
        arr = new int[row][col];
        board = new int[row][col];
        visited = new boolean[row][col];
    }
}