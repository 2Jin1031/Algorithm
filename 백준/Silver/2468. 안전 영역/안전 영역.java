import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;

    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        int[] heightInfo = readInput(br);


        int maxClusterCount = getMaxClusterCount(heightInfo);

        bw.write(String.valueOf(maxClusterCount));
        bw.close();
        br.close();
    }

    private static int getMaxClusterCount(int[] heightInfo) {
        int minHeight = heightInfo[0];
        int maxHeight = heightInfo[1];

        int maxClusterCount = 0;
        for (int height = minHeight; height <= maxHeight; height++) {
            int clusterCount = 0;
            initArray();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] >= height && !visited[i][j]) {
                        dfs(i, j, height);
                        clusterCount++;
                    }
                }
            }
            maxClusterCount = Math.max(maxClusterCount, clusterCount);
        }
        return maxClusterCount;
    }

    private static void initArray() {
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
    }

    private static void dfs(int startX, int startY, int height) {
        visited[startX][startY] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + DX[i];
                int nextY = current[1] + DY[i];

                if (isValidCoordinate(nextX, nextY) && map[nextX][nextY] >= height && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    private static int[] readInput(BufferedReader br) throws IOException {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        return new int[]{min, max};
    }
}
