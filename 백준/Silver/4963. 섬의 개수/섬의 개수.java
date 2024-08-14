import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;

    private static int[][] map;
    private static boolean[][] visited;

    private static final int[] DX = {0, 0, 1, -1, 1, -1, 1, -1};
    private static final int[] DY = {1, -1, 0, 0, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            if (!initialize(br)) {
                break;
            }

            int clusterCount = getClusterCount();
            bw.write(String.valueOf(clusterCount));
            bw.newLine();
            bw.flush();
        }

        bw.close();
        br.close();
    }

    private static boolean initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        if (N == 0 && M == 0) {
            return false;
        }

        map = new int[N][M];
        visited = new boolean[N][M];

        readInput(br);

        return true;
    }

    private static int getClusterCount() {
        int clusterCount = 0;
        resetVisitedArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    clusterCount++;
                }
            }
        }
        return clusterCount;
    }



    private static int getMaxHeight() {
        return Arrays.stream(map).flatMapToInt(Arrays::stream).max().orElse(0);
    }

    private static int getMinheight() {
        return Arrays.stream(map).flatMapToInt(Arrays::stream).min().orElse(0);
    }

    private static void resetVisitedArray() {
        Arrays.stream(visited).forEach(arr -> Arrays.fill(arr, false));
    }

    private static void dfs(int startX, int startY) {
        visited[startX][startY] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = current[0] + DX[i];
                int nextY = current[1] + DY[i];

                if (isValidCoordinate(nextX, nextY) && map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static void readInput(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
