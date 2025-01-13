import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int R, C;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    private static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    private static void bfs(int x, int y) {
        List<int[]> queue = new ArrayList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.remove(0);
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
                    continue;
                }

                if (map[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.add(new int[] {nextX, nextY});
            }
        }
    }
}