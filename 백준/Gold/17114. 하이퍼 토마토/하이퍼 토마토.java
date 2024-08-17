import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] mapSize;
    private static int[][][][][][][][][][][] map;
    private static boolean[][][][][][][][][][][] visited;
    private static ArrayList<int[]> ripeTomatoes = new ArrayList<>();

    private static final int DIMENSION = 11;
    private static final int D_SIZE = 22;
    private static final int[][] D_ARR = new int[DIMENSION][D_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        bfs(ripeTomatoes);

        int maxDays = calculateMaxDays();
        if (maxDays == -1) {
            bw.write("-1\n");
        } else {
            bw.write(String.valueOf(maxDays - 1) + "\n");
        }

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapSize = new int[DIMENSION];
        for (int i = DIMENSION - 1; i >= 0; i--) {
            mapSize[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[mapSize[0]][mapSize[1]][mapSize[2]][mapSize[3]][mapSize[4]][mapSize[5]][mapSize[6]][mapSize[7]][mapSize[8]][mapSize[9]][mapSize[10]];
        visited = new boolean[mapSize[0]][mapSize[1]][mapSize[2]][mapSize[3]][mapSize[4]][mapSize[5]][mapSize[6]][mapSize[7]][mapSize[8]][mapSize[9]][mapSize[10]];

        for (int i = 0; i < DIMENSION; i++) {
            D_ARR[i][i * 2] = -1; // -1 이동
            D_ARR[i][i * 2 + 1] = 1; // +1 이동
        }

        ripeTomatoes = new ArrayList<>();
        for (int i = 0; i < mapSize[0]; i++) {
            for (int j = 0; j < mapSize[1]; j++) {
                for (int k = 0; k < mapSize[2]; k++) {
                    for (int l = 0; l < mapSize[3]; l++) {
                        for (int m = 0; m < mapSize[4]; m++) {
                            for (int n = 0; n < mapSize[5]; n++) {
                                for (int o = 0; o < mapSize[6]; o++) {
                                    for (int p = 0; p < mapSize[7]; p++) {
                                        for (int q = 0; q < mapSize[8]; q++) {
                                            for (int r = 0; r < mapSize[9]; r++) {
                                                st = new StringTokenizer(br.readLine());
                                                for (int s = 0; s < mapSize[10]; s++) {
                                                    map[i][j][k][l][m][n][o][p][q][r][s] = Integer.parseInt(st.nextToken());
                                                    if (map[i][j][k][l][m][n][o][p][q][r][s] == 1) {
                                                        ripeTomatoes.add(new int[]{i, j, k, l, m, n, o, p, q, r, s});
                                                    }
                                                    if (map[i][j][k][l][m][n][o][p][q][r][s] == -1) {
                                                        setVisited(new int[]{i, j, k, l, m, n, o, p, q, r, s});
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void bfs(ArrayList<int[]> ripeTomatoes) {
        Queue<int[]> queue = new LinkedList<>();
        initBfsStart(queue, ripeTomatoes);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            exploreNeighbors(current, queue);
        }
    }

    private static void initBfsStart(Queue<int[]> queue, ArrayList<int[]> ripeTomatoes) {
        for (int[] ripeTomato : ripeTomatoes) {
            setVisited(ripeTomato);
            queue.add(ripeTomato.clone());
        }
    }

    private static void exploreNeighbors(int[] current, Queue<int[]> queue) {
        for (int i = 0; i < D_SIZE; i++) {
            int[] next = current.clone();
            for (int j = 0; j < DIMENSION; j++) {
                next[j] += D_ARR[j][i];
            }

            if (isValidCoordinate(next) && !isVisited(next)) {
                setVisited(next);
                setMapValue(next, getMapValue(current) + 1);
                queue.add(next.clone());
            }
        }
    }

    private static boolean isValidCoordinate(int[] next) {
        for (int i = 0; i < DIMENSION; i++) {
            if (next[i] < 0 || next[i] >= mapSize[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVisited(int[] indices) {
        return visited[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]][indices[5]][indices[6]][indices[7]][indices[8]][indices[9]][indices[10]];
    }

    private static void setVisited(int[] indices) {
        visited[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]][indices[5]][indices[6]][indices[7]][indices[8]][indices[9]][indices[10]] = true;
    }

    private static int getMapValue(int[] indices) {
        return map[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]][indices[5]][indices[6]][indices[7]][indices[8]][indices[9]][indices[10]];
    }

    private static void setMapValue(int[] indices, int value) {
        map[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]][indices[5]][indices[6]][indices[7]][indices[8]][indices[9]][indices[10]] = value;
    }

    private static int calculateMaxDays() {
        int maxDays = 0;
        for (int i = 0; i < mapSize[0]; i++) {
            for (int j = 0; j < mapSize[1]; j++) {
                for (int k = 0; k < mapSize[2]; k++) {
                    for (int l = 0; l < mapSize[3]; l++) {
                        for (int m = 0; m < mapSize[4]; m++) {
                            for (int n = 0; n < mapSize[5]; n++) {
                                for (int o = 0; o < mapSize[6]; o++) {
                                    for (int p = 0; p < mapSize[7]; p++) {
                                        for (int q = 0; q < mapSize[8]; q++) {
                                            for (int r = 0; r < mapSize[9]; r++) {
                                                for (int s = 0; s < mapSize[10]; s++) {
                                                    if (map[i][j][k][l][m][n][o][p][q][r][s] == 0) {
                                                        return -1;
                                                    }
                                                    maxDays = Math.max(maxDays, map[i][j][k][l][m][n][o][p][q][r][s]);
                                                }}}}}}}}}}}
        return maxDays;
    }
}
