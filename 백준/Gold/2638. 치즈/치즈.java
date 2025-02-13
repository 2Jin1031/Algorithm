import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    private static int cheeseCount;
    private static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }

        time = 0;
        while (cheeseCount > 0) {
            time++;
            meltCheese();
        }

        System.out.println(time);
    }

    private static void meltCheese() {
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (!isCoordinate(nx, ny) || visited[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        Queue<int[]> meltingCheese = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int airCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + DX[k];
                        int ny = j + DY[k];

                        if (isCoordinate(nx, ny) && visited[nx][ny]) {
                            airCount++;
                        }
                    }
                    if (airCount >= 2) {
                        meltingCheese.add(new int[]{i, j});
                    }
                }
            }
        }

        while (!meltingCheese.isEmpty()) {
            int[] pos = meltingCheese.poll();
            int x = pos[0];
            int y = pos[1];

            map[x][y] = 0;
            cheeseCount--;
        }
    }

    private static boolean isCoordinate(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}