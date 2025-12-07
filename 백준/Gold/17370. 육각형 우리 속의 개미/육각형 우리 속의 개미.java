import java.io.*;
import java.util.*;

public class Main {

    private static int[] DX = {-1, -1, 1, 1, 1, -1};
    private static int[] DY = {0, 1, 1, 0, -1, -1};

    private static int N;
    private static int[] start = {50, 50};
    private static int[][] arr = new int[100][100];
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    
        boolean[][] visited = new boolean[100][100];
        visited[50][50] = true;
        
        int nx = 50 + DX[0];
        int ny = 50 + DY[0];
        
        
        backtracking(new int[]{nx, ny}, 0, 1, visited);

        System.out.println(ans);
    }

    private static void backtracking(int[] current, int directionIdx, int count, boolean[][] visited) {
        if (count > N + 1) return ;
        
        int currentX = current[0];
        int currentY = current[1];

        if (visited[currentX][currentY]) {
            if (count == N + 1) ans++;
            return ;
        }

        visited[currentX][currentY] = true;

        int leftDirectionIdx = (directionIdx + 5) % 6;
        directionProcess(currentX, currentY, leftDirectionIdx, count, visited);
        
        int rightDirectionIdx = (directionIdx + 7) % 6;
        directionProcess(currentX, currentY, rightDirectionIdx, count, visited);

        visited[currentX][currentY] = false;
    }

    private static void directionProcess(int currentX, int currentY, int i, int count, boolean[][] visited) {
        int nextX = currentX + DX[i];
        int nextY = currentY + DY[i];

        backtracking(new int[]{nextX, nextY}, i, count + 1, visited);
    }
}