import java.io.*;
import java.util.*;

public class Main {

    private static int[] DX = {-1, 0, 1, 0};
    private static int[] DY = {0, 1, 0, -1};

    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] visited = new boolean[5][5];
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            visited[x - 1][y - 1] = true;
        }

        backtracking(visited, new int[]{0, 0}, new int[]{4, 4}, 5 * 5 - K - 2);
        System.out.println(ans);
    }

    private static void backtracking(boolean[][] visited, int[] jCurrent, int[] hCurrent, int rest) {
        // 만일 둘 이 동일한 곳에서 만나면서 모든 것을 수확했다면, ans++;
        int jCurrentX = jCurrent[0];
        int jCurrentY = jCurrent[1];
        
        int hCurrentX = hCurrent[0];
        int hCurrentY = hCurrent[1];
        if (jCurrentX == hCurrentX && jCurrentY == hCurrentY) {
            if (rest <= 0) {
                ans++;
            }
            return ;
        }

        // 방문 처리
        visited[jCurrentX][jCurrentY] = true;
        visited[hCurrentX][hCurrentY] = true;

        for (int i = 0; i < 4; i++) {
            int jNextX = jCurrentX + DX[i];
            int jNextY = jCurrentY + DY[i];

            if (isValidCoordinate(jNextX, jNextY) && !visited[jNextX][jNextY]) {
                for (int j = 0; j < 4; j++) {
                    int hNextX = hCurrentX + DX[j];
                    int hNextY = hCurrentY + DY[j];

                    if (isValidCoordinate(hNextX, hNextY) && !visited[hNextX][hNextY]) {
                        backtracking(visited, new int[]{jNextX, jNextY}, new int[]{hNextX, hNextY}, rest - 2);
                    }
                }        
            }
        }

        visited[jCurrentX][jCurrentY] = false;
        visited[hCurrentX][hCurrentY] = false;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5;
    }
}