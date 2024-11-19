import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int R, C;
    private static boolean[][] arr;
    private static boolean[][] visited;
    private static int[][] rules;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialize(br);

        ArrayList<int[]> startPositions = new ArrayList<>();
        for (int j = 0; j < C; j++) {
            if (!arr[0][j]) { // road
                startPositions.add(new int[]{0, j});
            }
        }
        int result = BFS(startPositions);
        bw.write((result + "\n"));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new boolean[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) == 0; // 0: wall(true), 1: road(false)
                if (arr[i][j]) {
                    visited[i][j] = true;
                }
            }
        }

        int N = Integer.parseInt(br.readLine());
        rules = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rules[i][0] = Integer.parseInt(st.nextToken());
            rules[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    private static int BFS(ArrayList<int[]> startPositions) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] startPosition : startPositions) {
            queue.offer(new int[]{startPosition[0], startPosition[1], 0});
            visited[startPosition[0]][startPosition[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int moveCount = current[2];

            if (currentX == R - 1) {
                return moveCount;
            }

            for (int[] rule : rules) {
                int nextX = currentX + rule[0];
                int nextY = currentY + rule[1];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY, moveCount + 1});
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < R && nextY >= 0 && nextY < C;
    }
}