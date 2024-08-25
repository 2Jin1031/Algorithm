import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    private static int blockCount = 0;
    private static int minTime = Integer.MAX_VALUE; // 초기값을 최대값으로 설정

    private static ArrayList<int[]> virusPositions = new ArrayList<>();

    private final static int[] DX = {0, 0, 1, -1};
    private final static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        ArrayList<int[]> activeViruses = new ArrayList<>();
        placeViruses(0, 0, activeViruses);

        // 모든 경우에서 바이러스를 퍼뜨릴 수 없는 경우
        if (minTime == Integer.MAX_VALUE) {
            minTime = -1;
        }

        bw.write(minTime + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusPositions.add(new int[]{i, j});
                }
                else if (map[i][j] == 1) {
                    visited[i][j] = true;
                }
                else if (map[i][j] == 0) {
                    blockCount++;
                }
            }
        }
    }

    private static void placeViruses(int index, int start, ArrayList<int[]> activeViruses) {
        if (index == M) {
            int timeTaken = bfs(activeViruses);
            if (timeTaken == -1) {
                return;
            } else if (timeTaken < minTime) { // minTime == Integer.MAX_VALUE 대신 timeTaken < minTime로 비교
                minTime = timeTaken;
            }
            return;
        }

        for (int i = start; i < virusPositions.size(); i++) {
            activeViruses.add(virusPositions.get(i));
            placeViruses(index + 1, i + 1, activeViruses);
            activeViruses.remove(activeViruses.size() - 1);
        }
    }

    private static int bfs(ArrayList<int[]> activeViruses) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] timeMap = new int[N][N];
        boolean[][] localVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            System.arraycopy(visited[i], 0, localVisited[i], 0, visited[i].length);
            Arrays.fill(timeMap[i], -1);
        }

        for (int[] virus : activeViruses) {
            queue.add(virus);
            timeMap[virus[0]][virus[1]] = 0;
            localVisited[virus[0]][virus[1]] = true;
        }

        int localBlockCount = blockCount;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if (localBlockCount == 0) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && !localVisited[nextX][nextY] && map[nextX][nextY] != 1) {
                    if (map[nextX][nextY] == 0) {
                        localBlockCount--;
                    }
                    timeMap[nextX][nextY] = timeMap[currentX][currentY] + 1;
                    localVisited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        int timeTaken = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !localVisited[i][j]) { // 지나가지 않은 빈칸
                    return -1; // 바이러스 퍼뜨릴 수 없음
                } else if (timeMap[i][j] > timeTaken) { // 최대 시간 갱신
                    timeTaken = timeMap[i][j];
                }
            }
        }
        return timeTaken;
    }

    private static boolean isValidCoordinate(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
