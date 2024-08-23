import java.io.*;
import java.util.*;

public class Main {
    private static int N, L, R;
    private static int[][] map;
    private static boolean[][] visited;

    private final static int[] DX = {0, 0, 1, -1};
    private final static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int day = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean hasMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            hasMoved = true;
                        }
                    }
                }
            }

            if (!hasMoved) {
                break;
            }
            day++;
        }

        bw.write(day + "\n");
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> area = new ArrayList<>();

        queue.offer(new int[] {startX, startY});
        visited[startX][startY] = true;
        area.add(new int[] {startX, startY});

        int sum = map[startX][startY];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    int diff = Math.abs(map[currentX][currentY] - map[nextX][nextY]);
                    if (diff >= L && diff <= R) {
                        queue.offer(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                        area.add(new int[] {nextX, nextY});
                        sum += map[nextX][nextY];
                    }
                }
            }
        }

        if (area.size() > 1) {
            int average = sum / area.size();
            for (int[] pos : area) {
                map[pos[0]][pos[1]] = average;
            }
            return true;
        }
        return false;
    }

    private static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}