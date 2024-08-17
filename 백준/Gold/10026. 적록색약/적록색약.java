import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N;
    private static char[][] map;
    private static boolean[][] visitedNormal;
    private static boolean[][] visitedRedGreen;

    private static final int D_SIZE = 4;
    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int normalZones = 0;
        int redGreenZones = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedNormal[i][j]) {
                    bfs(new int[]{i, j}, true);
                    normalZones++;
                }
                if (!visitedRedGreen[i][j]) {
                    bfs(new int[]{i, j}, false);
                    redGreenZones++;
                }
            }
        }

        bw.write(normalZones + " " + redGreenZones);

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visitedNormal = new boolean[N][N];
        visitedRedGreen = new boolean[N][N];
    }

    private static void bfs(int[] start, boolean isNormal) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start.clone());

        if (isNormal) {
            visitedNormal[start[0]][start[1]] = true;
        }
        else {
            visitedRedGreen[start[0]][start[1]] = true;
        }

        char color = map[start[0]][start[1]];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < D_SIZE; i++) {
                int nextX = current[0] + DX[i];
                int nextY = current[1] + DY[i];

                if (isValidCoordinate(nextX, nextY)) {
                    if (isNormal && !visitedNormal[nextX][nextY] && map[nextX][nextY] == color) {
                        visitedNormal[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    } else if (!isNormal && !visitedRedGreen[nextX][nextY] && isValidSameZone(color, map[nextX][nextY])) {
                        visitedRedGreen[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N;
    }

    private static boolean isValidSameZone(char cluster1, char cluster2) {
        return cluster1 == cluster2 || (cluster1 == 'R' && cluster2 == 'G') || (cluster1 == 'G' && cluster2 == 'R');
    }
}
