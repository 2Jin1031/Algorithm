import java.io.*;
import java.util.*;

public class Main {

    private static int[] DX = {-1, 0, 1, 0};
    private static int[] DY = {0, 1, 0, -1};

    private static int R, C, K;
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'T') {
                    visited[i][j] = true;
                }
            }
        }

        visited[R - 1][0] = true;
        dfs(1, R - 1, 0, visited);
        System.out.println(ans);
    }

    private static void dfs(int depth, int currentX, int currentY, boolean[][] visited) { 
        if (depth == K) {
            if (currentX == 0 && currentY == C - 1) {
                ans++;    
            }
            return ;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = currentX + DX[i];
            int nextY = currentY + DY[i];

            if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(depth + 1, nextX, nextY, visited);
                visited[nextX][nextY] = false;
            }
        }
        
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < R && nextY >= 0 && nextY < C;
    }

}