import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static ArrayList<int[]> possibleVirusPositions = new ArrayList<>();
    private static int minTime = -1;

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        placeViruses(0, 0, new ArrayList<>());

        bw.write(minTime + "\n");

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) { // 바이러스 놓을 수 있는 곳
                    possibleVirusPositions.add(new int[]{i, j});
                }
            }
        }
    }

    private static void placeViruses(int index, int start, ArrayList<int[]> virusPositions) {
        if (index == M) {
            int timeTaken = bfs(virusPositions);

            if (timeTaken == -1) {
                return;
            } else if (timeTaken < minTime || minTime == -1) {
                minTime = timeTaken;
            }

            return;
        }

        for (int i = start; i < possibleVirusPositions.size(); i++) {
            virusPositions.add(possibleVirusPositions.get(i));
            placeViruses(index + 1, i + 1, virusPositions);
            virusPositions.remove(virusPositions.size() - 1);
        }
    }

    private static int bfs(ArrayList<int[]> virusPositions) {
        int[][] localSpreadViruses = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(localSpreadViruses[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] virus : virusPositions) {
            queue.offer(virus);
            localSpreadViruses[virus[0]][virus[1]] = 0;
        }

        int maxTime = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (isValidCoordinate(nx, ny) && localSpreadViruses[nx][ny] == -1 && map[nx][ny] != 1) {
                    localSpreadViruses[nx][ny] = localSpreadViruses[x][y] + 1;
                    maxTime = Math.max(maxTime, localSpreadViruses[nx][ny]);
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((map[i][j] == 0 || map[i][j] == 2) && localSpreadViruses[i][j] == -1) {
                    return -1;
                }
            }
        }

        return maxTime;
    }

    private static boolean isValidCoordinate(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }
}