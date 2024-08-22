import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;

    private static int[] areaSize;
    private static int[][] areaId;
    private static boolean[][] visited;
    private static ArrayList<int[]> wallPostions = new ArrayList<>();
    private final static int[] DX = {0, 0, 1, -1};
    private final static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        calculateAreaSizes();

        for (int[] wall : wallPostions) {
            int x = wall[0];
            int y = wall[1];
            Set<Integer> uniqueAreas = new HashSet<>();
            int sum = 1; 

            for (int i = 0; i < 4; i++) {
                int nextX = x + DX[i];
                int nextY = y + DY[i];

                if (isValidCoordinate(nextX, nextY) && map[nextX][nextY] == 0) {
                    uniqueAreas.add(areaId[nextX][nextY]);
                }
            }

            for (int id : uniqueAreas) {
                sum += areaSize[id];
            }

            map[x][y] = sum;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(map[i][j] % 10 + "");
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        areaId = new int[N][M];
        areaSize = new int[N * M + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                if (map[i][j] == 1) {
                    wallPostions.add(new int[]{i, j});
                }
            }
        }
    }

    private static void calculateAreaSizes() {
        int areaIdCounter = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    int size = bfs(i, j, areaIdCounter);
                    areaSize[areaIdCounter] = size;
                    areaIdCounter++;
                }
            }
        }
    }

    private static int bfs(int startX, int startY, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        areaId[startX][startY] = id;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            count++;

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    areaId[nextX][nextY] = id;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return count;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }
}