import java.util.*;
import java.io.*;

public class Main {

    private static int[][] DX = {{0, -1, -1}, {0, 1, 1}};
    private static int[][] DY = {{-1, -1, 0}, {1, 1, 0}};

    static int N, M;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        boolean[][] visited = new boolean[N][M];
    
        ans++;
    
        backtrack(visited, 0);
        System.out.println(ans);
    }

    private static void backtrack(boolean[][] visited, int start) {
        for (int idx = start; idx < N * M; idx++) {
            int x = idx / M;
            int y = idx % M;
    
            if (visited[x][y]) continue;
            visited[x][y] = true;
    
            if (makesFull2x2(visited, x, y)) {
                visited[x][y] = false;
                continue;
            }
    
            ans++;
    
            backtrack(visited, idx + 1);
    
            visited[x][y] = false;
        }
    }
    
    
    private static boolean makesFull2x2(boolean[][] visited, int x, int y) {
    
        for (int i = 0; i < 2; i++) {
            boolean full = true;
            for (int j = 0; j < 3; j++) {
                int nx = x + DX[i][j];
                int ny = y + DY[0][j];
    
                if (!isValidCoordinate(nx, ny) || !visited[nx][ny]) {
                    full = false;
                    break;
                }
            }
            if (full) return true;
        }
        for (int i = 0; i < 2; i++) {
            boolean full = true;
            for (int j = 0; j < 3; j++) {
                int nx = x + DX[i][j];
                int ny = y + DY[1][j];
    
                if (!isValidCoordinate(nx, ny) || !visited[nx][ny]) {
                    full = false;
                    break;
                }
            }
            if (full) return true;
        }
        return false;
    }
    
    private static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
}
