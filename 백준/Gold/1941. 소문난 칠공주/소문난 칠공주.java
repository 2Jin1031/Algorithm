import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    private static char[][] arr;
    private static boolean[][] visited;
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        backtracking(0, 0, 0, 0);
        System.out.println(ans);
    }

    private static void backtracking(int idx, int sCount, int yCount, int totalCount) {
        if (yCount >= 4) {
            return;
        }

        if (totalCount == 7) {
            if (isConnected()) {
                ans++;
            }
            return;
        }

        if (idx == 25) {
            return;
        }

        int x = idx / 5;
        int y = idx % 5;

        visited[x][y] = true;
        if (arr[x][y] == 'S') {
            backtracking(idx + 1, sCount + 1, yCount, totalCount + 1);
        } else {
            backtracking(idx + 1, sCount, yCount + 1, totalCount + 1);
        }
        visited[x][y] = false;

        backtracking(idx + 1, sCount, yCount, totalCount);
    }

    private static boolean isConnected() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    list.add(new int[]{i, j});
                }
            }
        }

        if (list.size() != 7) return false;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] seen = new boolean[5][5];

        int[] start = list.get(0);
        q.offer(start);
        seen[start[0]][start[1]] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + DX[k];
                int ny = y + DY[k];

                if (!isValidCoordinate(nx, ny)) continue;
                if (!visited[nx][ny]) continue;   // 선택된 7칸 안에서만 이동
                if (seen[nx][ny]) continue;

                seen[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                cnt++;
            }
        }

        return cnt == 7;
    }

    private static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}