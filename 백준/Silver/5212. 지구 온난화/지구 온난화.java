import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    private static int R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == 'X') map[i][j] = true;
            }
        }

        boolean[][] sink = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!map[i][j]) continue;
                int sea = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + DX[k];
                    int ny = j + DY[k];
                    if (!isValid(nx, ny) || !map[nx][ny]) sea++;
                }
                if (sea >= 3) sink[i][j] = true;
            }
        }

        boolean[][] after = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                after[i][j] = map[i][j] && !sink[i][j];
            }
        }

        int minX = R, maxX = -1, minY = C, maxY = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (after[i][j]) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        if (maxX == -1) {
            return;
        }

        StringBuilder out = new StringBuilder();
        for (int i = minX; i <= maxX; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = minY; j <= maxY; j++) {
                row.append(after[i][j] ? 'X' : '.');
            }
            out.append(row).append('\n');
        }
        System.out.print(out);
    }

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }
}