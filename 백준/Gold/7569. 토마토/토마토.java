import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    private static int N;
    private static int M;
    private static int H;
    private static int[][][] map;
    private static boolean[][][] visited;
    private static ArrayList<int[]> ripeTomatoes = new ArrayList<>();

    private static final int D_SIZE = 6;
    private static final int[] DX = {-1, 1, 0, 0, 0, 0};
    private static final int[] DY = {0, 0, -1, 1, 0, 0};
    private static final int[] DH = {0, 0, 0, 0, -1, 1};

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

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    if (map[h][i][j] == 1) {
                        ripeTomatoes.add(new int[]{h, i, j});
                    }
                    if (map[h][i][j] == -1) {
                        visited[h][i][j] = true;
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

    private static void exploreNeighbors(int[] current, Queue<int[]> queue) {
        for (int i = 0; i < D_SIZE; i++) {
            int nextH = current[0] + DH[i];
            int nextX = current[1] + DX[i];
            int nextY = current[2] + DY[i];

            if (isValidCoordinate(nextH, nextX, nextY) && !visited[nextH][nextX][nextY]) {
                visited[nextH][nextX][nextY] = true;
                map[nextH][nextX][nextY] = map[current[0]][current[1]][current[2]] + 1;
                queue.add(new int[]{nextH, nextX, nextY});
            }
        }
    }

    private static boolean isValidCoordinate(int nextH, int nextX, int nextY) {
        return nextH >= 0 && nextX >= 0 && nextY >= 0 && nextH < map.length && nextX < map[0].length && nextY < map[0][0].length;

    }

    private static void initBfsStart(Queue<int[]> queue, ArrayList<int[]> ripeTomatoes) {
        for (int[] tomato : ripeTomatoes) {
            queue.add(tomato);
            visited[tomato[0]][tomato[1]][tomato[2]] = true;
        }
    }

    private static int calculateMaxDays() {
        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[h][i][j] == 0) {
                        return -1;
                    }
                    max = Math.max(max, map[h][i][j]);
                }
            }
        }

        return max;
    }
}
