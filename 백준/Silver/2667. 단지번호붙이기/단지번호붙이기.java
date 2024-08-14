import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        // input
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        // logic
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    result.add(BFS(i, j));
                }
            }
        }

        // output
        bw.write(result.size() + "\n");
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + "\n");
        }
        br.close();
        bw.close();
    }

    private static int BFS(int i, int j) {
        visited[i][j] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            cnt++;

            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return cnt;
    }
}
