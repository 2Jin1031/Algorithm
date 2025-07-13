import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    private static int count = 0;
    private static int direction;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        if (visited[R][C]) {
            System.out.println(0);
            return ;
        }

        int cx = R;
        int cy = C;
        while (true) {
            int[] result = func(cx, cy);
            if (result.length == 1) {
                break;
            }
            cx = result[0];
            cy = result[1];
        }

        System.out.println(count);
    }

    private static int[] func(int cx, int cy) {
        if (!visited[cx][cy]) { // 1
            visited[cx][cy] = true;
            count++;
        }

        boolean nearClean = true;
        for (int i = 0; i < 4; i++) {
            int nextX = cx + dx[i];
            int nextY = cy + dy[i];
            if (!validCoordinate(nextX, nextY)) {
                continue;
            }

            if (!visited[nextX][nextY]) { // false(청소가 안되어있음) 라면 nearClean(근처가 깨끗한지)는 false
                nearClean = false;
                break;
            }
        }

        if (nearClean) { // 2 (모두 청소 되어 있음 -> 청소되지 않은 빈 칸이 없음)
            int oppositeDirection = (direction + 2) % 4; //2.1-1 : 후진
            int nextX = cx + dx[oppositeDirection];
            int nextY = cy + dy[oppositeDirection];
            if (validCoordinate(nextX, nextY) && map[nextX][nextY] == 0) { // 2.1
                return new int[]{nextX, nextY};
            } else { // 2.2 -> 작동 정지 조건
                return new int[]{-1};
            }
        } else { // 3 (빈 칸이 있는 경우)
            while (true) {
                direction = (direction + 3) % 4; // 3.1
                int nextX = cx + dx[direction];
                int nextY = cy + dy[direction];
                if (!visited[nextX][nextY]) { // 3.2
                    return new int[]{nextX, nextY};
                }
            }
        }
    }

    private static boolean validCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M; 
    }
 }