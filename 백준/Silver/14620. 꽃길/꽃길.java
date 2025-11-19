import java.io.*;
import java.util.*;

public class Main {

    private static int[] DX = {-1, 0, 1, 0};
    private static int[] DY = {0, 1, 0, -1};
    
    private static int N;
    private static int[][] arr;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0, new boolean[N][N]);
        System.out.println(ans);
    }

    private static void backtracking(int count, int cost, boolean[][] visited) {
        if (count == 3) {
            ans = Math.min(ans, cost);
            return ;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) { // 이미 방문한 곳이라면 다른 좌표 찾기
                    continue;
                }

                boolean flag = true;
                int localCost = arr[i][j];

                for (int k = 0; k < 4; k++) {
                    int nextX = i + DX[k];
                    int nextY = j + DY[k];

                    if (!isValidCoordinate(nextX, nextY) || visited[nextX][nextY]) {// 유효하지 않거나 이미 방문한 곳이라면
                        flag = false;
                        break;
                    }

                    localCost += arr[nextX][nextY];
                }

                if (!flag) { // 꽃을 심을 수 없는 곳이라면 다른 좌표 찾기
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nextX = i + DX[k];
                    int nextY = j + DY[k];

                    visited[nextX][nextY] = true;
                }
                
                backtracking(count + 1, cost + localCost, visited);
                
                for (int k = 0; k < 4; k++) {
                    int nextX = i + DX[k];
                    int nextY = j + DY[k];

                    visited[nextX][nextY] = false;
                }
            }
        }        
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N;
    }
}