import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static char[][] map;
    private static int[] visited;
    private static boolean[] visited1;

    private static final int D_SIZE = 4;
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        bw.write(dfs(new int[]{0, 0}, 1) + "\n");

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[26];
        visited1 = new boolean[26];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    private static int dfs(int[] current, int depth) {
        if (visited1[map[current[0]][current[1]] - 'A']) {
            return depth;
        }

        visited1[map[current[0]][current[1]] - 'A'] = true;

        int max = depth;
        for (int i = 0; i < D_SIZE; i++) {
            int nextX = current[0] + DX[i];
            int nextY = current[1] + DY[i];

            if (isValidCoordinate(nextX, nextY) && !visited1[map[nextX][nextY] - 'A']) {
                max = Math.max(max, dfs(new int[]{nextX, nextY}, depth + 1));
            }
        }

        visited1[map[current[0]][current[1]] - 'A'] = false;
        return max;
    }
    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }
}

