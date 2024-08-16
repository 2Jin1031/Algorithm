import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    private static int T;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] start = new int[2];
    private static int[] end = new int[2];

    private static final int[] DX = {-1, -1, -2, -2, 1, 1, 2, 2};
    private static final int[] DY = {-2, 2, -1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            initialize(br);

            bw.write(bfs(start) + "\n");
        }
        br.close();
        bw.close();

    }

    private static void initialize(BufferedReader br) throws IOException {
        int I = Integer.parseInt(br.readLine());
        map = new int[I][I];
        visited = new boolean[I][I];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            end[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == end[0] && current[1] == end[1]) {
                return map[current[0]][current[1]];
            }

            for (int i = 0; i < 8; i++) {
                int nextX = current[0] + DX[i];
                int nextY = current[1] + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                    continue;
                }

                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = map[current[0]][current[1]] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return -1;
    }
}
