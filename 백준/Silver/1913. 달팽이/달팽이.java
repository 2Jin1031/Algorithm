import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        int x = N / 2, y = N / 2; 
        int num = 1;
        map[x][y] = num;

        int ansX = (M == 1) ? x : -1;
        int ansY = (M == 1) ? y : -1;

        int step = 1;
        int dir = 0;

        while (num < N * N) {
            for (int repeat = 0; repeat < 2; repeat++) {
                for (int s = 0; s < step && num < N * N; s++) {
                    x += dx[dir];
                    y += dy[dir];
                    num++;
                    map[x][y] = num;
                    if (num == M) {
                        ansX = x; 
                        ansY = y; 
                    }
                }
                dir = (dir + 1) % 4;
            }
            step++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);

        System.out.println((ansX + 1) + " " + (ansY + 1));
    }
}