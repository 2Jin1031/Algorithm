import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<int[]> ripeTomatoes = new ArrayList<>();

    private static final int D_SIZE = 4;
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

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
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    ripeTomatoes.add(new int[]{i, j});
                }
                if (map[i][j] == -1) {
                    visited[i][j] = true;
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
            int nextX = current[0] + DX[i];
            int nextY = current[1] + DY[i];

            if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                map[nextX][nextY] = map[current[0]][current[1]] + 1;
                queue.add(new int[]{nextX, nextY});
            }
        }
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length;

    }

    private static void initBfsStart(Queue<int[]> queue, ArrayList<int[]> ripeTomatoes) {
        for (int [] tomato : ripeTomatoes) {
            queue.add(tomato);
            visited[tomato[0]][tomato[1]] = true;
        }
    }

    private static int calculateMaxDays() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }
}
