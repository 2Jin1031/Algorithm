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

        int normalZones = countZones(true);
        int redGreenZones = countZones(false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedNormal[i][j]) {
                    bfs(i, j, true);
                    normalZones++;
                }
                if (!visitedRedGreen[i][j]) {
                    bfs(i, j, false);
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

    private static int countZones(boolean isNormal) {
        int zoneCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (shouldExploreZone(i, j, isNormal)) {
                    bfs(i, j, isNormal);
                    zoneCount++;
                }
            }
        }
        return zoneCount;
    }

    private static boolean shouldExploreZone(int i, int j, boolean isNormal) {
        return isNormal ? !visitedNormal[i][j] : !visitedRedGreen[i][j];
    }

    private static void bfs(int startX, int startY, boolean isNormal) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});

        markVisited(startX, startY, isNormal);

        if (isNormal) {
            visitedNormal[startX][startY] = true;
        }
        else {
            visitedRedGreen[startX][startY] = true;
        }

        char color = map[startX][startY];
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

    private static void markVisited(int startX, int startY, boolean isNormal) {
        if (isNormal) {
            visitedNormal[startX][startY] = true;
        }
        else {
            visitedRedGreen[startX][startY] = true;
        }
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N;
    }

    private static boolean isValidSameZone(char cluster1, char cluster2) {
        return cluster1 == cluster2 || (cluster1 == 'R' && cluster2 == 'G') || (cluster1 == 'G' && cluster2 == 'R');
    }
}
