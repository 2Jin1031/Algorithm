import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int row, col;
    private static ArrayList<ArrayList<int[]>> position;
    private static int time;
    private static int[] resultPosition = new int[2];

    private static int N;
    private static int K;

    private static int[][] arr;
    private static int[][] timeBoard;
    private static boolean[][] visited;

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        int result = bfs();
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        initArrSize(N);

        position = new ArrayList<>(K + 1);
        for (int i = 0; i < K + 1; i++) {
            position.add(new ArrayList<>());
        }

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    visited[i][j] = true;
                    position.get(arr[i][j]).add(new int[]{i, j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken());
        resultPosition[0] = Integer.parseInt(st.nextToken());
        resultPosition[1] = Integer.parseInt(st.nextToken());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < position.size(); i++) {
            if (position.get(i) != null) {
                for (int[] pos : position.get(i)) {
                    queue.offer(new int[]{pos[0], pos[1]});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if (timeBoard[currentX][currentY] > time) {
                continue;
            }

            if (currentX == resultPosition[0] - 1 && currentY == resultPosition[1] - 1) {
                return arr[resultPosition[0] - 1][resultPosition[1] - 1];
            }

            for (int i = 0; i < DX.length; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    timeBoard[nextX][nextY] = timeBoard[currentX][currentY] + 1;
                    arr[nextX][nextY] = arr[currentX][currentY];
                    queue.offer(new int[]{nextX, nextY});

                }
            }
        }
        return 0;
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
        timeBoard = new int[row][col];
        visited = new boolean[row][col];
    }
}