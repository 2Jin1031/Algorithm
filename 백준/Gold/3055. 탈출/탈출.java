import java.io.*;
import java.util.*;

public class Main {
    private static int R, C;
    private static char[][] map;
    private static int[][] hedgehogDistance;
    private static int[][] waterDistance;

    private static int[] hedgehogStart;
    private static ArrayList<int[]> waterStart;

    private static int[] D;
    private static int D_distance;

    private final static int[] DX = {0, 0, 1, -1};
    private final static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        waterBfs(waterStart); // 물의 BFS를 먼저 실행
        hedgehogBfs(hedgehogStart); // 그 다음 고슴도치의 BFS 실행

        D_distance = hedgehogDistance[D[0]][D[1]];

        if (D_distance == -1 || (waterDistance[D[0]][D[1]] != -1 && D_distance >= waterDistance[D[0]][D[1]])) {
            bw.write("KAKTUS");
        } else {
            bw.write(String.valueOf(D_distance));
        }

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        hedgehogDistance = new int[R][C];
        waterDistance = new int[R][C];

        waterStart = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            Arrays.fill(hedgehogDistance[i], -1);
            Arrays.fill(waterDistance[i], -1);
        }

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    hedgehogStart = new int[]{i, j};
                } else if (map[i][j] == '*') {
                    waterStart.add(new int[]{i, j});
                } else if (map[i][j] == 'D') {
                    D = new int[]{i, j};
                }
            }
        }
    }

    private static void hedgehogBfs(int[] hedgehogStart) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(hedgehogStart);
        hedgehogDistance[hedgehogStart[0]][hedgehogStart[1]] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && map[nextX][nextY] != 'X' && hedgehogDistance[nextX][nextY] == -1 && 
                    (waterDistance[nextX][nextY] == -1 || hedgehogDistance[currentX][currentY] + 1 < waterDistance[nextX][nextY])) {
                    queue.offer(new int[]{nextX, nextY});
                    hedgehogDistance[nextX][nextY] = hedgehogDistance[currentX][currentY] + 1;
                }
            }
        }
    }

    private static void waterBfs(ArrayList<int[]> waterStart) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] start : waterStart) {
            queue.offer(start);
            waterDistance[start[0]][start[1]] = 0;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && map[nextX][nextY] != 'X' && map[nextX][nextY] != 'D' && waterDistance[nextX][nextY] == -1) {
                    queue.offer(new int[]{nextX, nextY});
                    waterDistance[nextX][nextY] = waterDistance[currentX][currentY] + 1;
                }
            }
        }
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < R && nextY >= 0 && nextY < C;
    }
}