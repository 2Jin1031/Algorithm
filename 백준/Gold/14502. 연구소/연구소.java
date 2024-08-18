import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static final ArrayList<int[]> blankPositions = new ArrayList<>();
    private static final int countWall = 3;
    private static int totalWallCount = countWall;


    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int maxSafeArea = findMaxSafeArea();
        bw.write(maxSafeArea + "\n");
        br.close();
        bw.close();
    }

    private static int findMaxSafeArea() {
        int blankSize = blankPositions.size();
        int minVirusSpread = Integer.MAX_VALUE;
        for (int i = 0; i < blankSize; i++) {
            for (int j = i + 1; j < blankSize; j++) {
                for (int k = j + 1; k < blankSize; k++) {
                    placeWalls(i, j, k);
                    minVirusSpread = Math.min(minVirusSpread, exploreBFS());
                    removeWalls(i, j, k);
                }
            }
        }
        return N * M - minVirusSpread - totalWallCount;
    }

    private static void removeWalls(int i, int j, int k) {
        breakWall(blankPositions.get(i));
        breakWall(blankPositions.get(j));
        breakWall(blankPositions.get(k));
    }

    private static void placeWalls(int i, int j, int k) {
        setWall(blankPositions.get(i));
        setWall(blankPositions.get(j));
        setWall(blankPositions.get(k));
    }

    private static void breakWall(int[] first) {
        map[first[0]][first[1]] = 0;
    }

    private static void setWall(int[] first) {
        map[first[0]][first[1]] = 1;
    }

    private static void resetVisitedArray() {
        Arrays.stream(visited).forEach(arr -> Arrays.fill(arr, false));
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                    totalWallCount++;
                }
                if (map[i][j] == 0) {
                    blankPositions.add(new int[]{i, j});
                }
            }
        }
    }

    private static int exploreBFS() {
        resetVisitedArray();
        int virusCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2 && !visited[i][j]) {
                    virusCount += bfs(new int[]{i, j});
                }
            }
        }
        return virusCount;
    }

    private static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        int virusCount = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + DX[i];
                int nextY = y + DY[i];

                if (isValidPosition(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 0) {
                    queue.offer(new int[]{nextX, nextY});
                    virusCount++;
                    visited[nextX][nextY] = true;
                }
            }
        }
        return virusCount;
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
