import java.io.*;
import java.util.*;

public class Main {
    private static int L, R, C;
    private static char[][][] map;
    private static boolean[][][] visited;
    private static int[][][] path;

    private static int[] startLocation;
    private static int[] endLocation;

    private final static int[] DX = {0, 0, 1, -1, 0, 0};
    private final static int[] DY = {1, -1, 0, 0, 0, 0};
    private final static int[] DZ = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int systemCode = initialize(br);
            if (systemCode == -1) {
                break;
            }
            int distance = bfs(startLocation);
            if (distance == -1) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + distance + " minute(s).\n");
            }

        }

        bw.close();
        br.close();
    }

    private static int initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if (L == 0 && R == 0 && C == 0) {
            return -1;
        }

        map = new char[L][R][C];
        visited = new boolean[L][R][C];
        path = new int[L][R][C];

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                Arrays.fill(path[i][j], -1);
            }
        }

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String inputLine = br.readLine();
                for (int k = 0; k < C; k++) {
                    map[i][j][k] = inputLine.charAt(k);
                    if (map[i][j][k] == 'S') {
                        startLocation = new int[]{i, j, k};
                    } else if (map[i][j][k] == 'E') {
                        endLocation = new int[]{i, j, k};
                    } else if (map[i][j][k] == '#') {
                        visited[i][j][k] = true;
                    }
                }
            }
            br.readLine();
        }
        return 0;
    }

    private static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], start[2]});
        visited[start[0]][start[1]][start[2]] = true;
        path[start[0]][start[1]][start[2]] = 0;


        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentZ = current[2];
            int currentCount = path[currentX][currentY][currentZ];

            if (currentX == endLocation[0] && currentY == endLocation[1] && currentZ == endLocation[2]) {
                return currentCount;
            }

            for (int i = 0; i < 6; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];
                int nextZ = currentZ + DZ[i];
                if (isValidCoordinate(nextX, nextY, nextZ) && !visited[nextX][nextY][nextZ] && map[nextX][nextY][nextZ] != '#') {
                    queue.offer(new int[]{nextX, nextY, nextZ});
                    visited[nextX][nextY][nextZ] = true;
                    path[nextX][nextY][nextZ] = currentCount + 1;
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nx, int ny, int nz) {
        return nx >= 0 && ny >= 0 && nz >= 0 && nx < L && ny < R && nz < C;
    }
}