import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static final ArrayList<int[]> blankPositions = new ArrayList<>();
    private static int countWall = 3;

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int blankSize = blankPositions.size();
        int minVirus = Integer.MAX_VALUE;
        for (int i = 0; i < blankSize; i++) {
            for (int j = 0; j < blankSize; j++) {
                for (int k = 0; k < blankSize; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    resetVisitedArray();

                    int[] first = blankPositions.get(i);
                    int[] second = blankPositions.get(j);
                    int[] third = blankPositions.get(k);

                    map[first[0]][first[1]] = 1;
                    map[second[0]][second[1]] = 1;
                    map[third[0]][third[1]] = 1;

                    int countVirus = exploreBFS();
                    minVirus = Math.min(minVirus, countVirus);

                    map[first[0]][first[1]] = 0;
                    map[second[0]][second[1]] = 0;
                    map[third[0]][third[1]] = 0;
                }
            }
        }
        int maxSafeArea = N * M - minVirus - countWall;
        bw.write(maxSafeArea + "\n");
        br.close();
        bw.close();
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
                    countWall++;
                }
                if (map[i][j] == 0) {
                    blankPositions.add(new int[]{i, j});
                }
            }
        }
    }

    private static int exploreBFS() {
        int countVirus = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2 && !visited[i][j]) {
                    countVirus += bfs(new int[] {i, j});
                }
            }
        }
        return countVirus;
    }

    private static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        int countVirus = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + DX[i];
                int nextY = y + DY[i];

                if (isValidPosition(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 0) {
                    queue.offer(new int[] {nextX, nextY});
                    countVirus++;
                    visited[nextX][nextY] = true;
                }
            }
        }
        return countVirus;
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}