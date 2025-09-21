import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] a = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int T = Integer.parseInt(br.readLine().trim());

        int cnt = 0;
        int[] win = new int[9];
        for (int i = 0; i + 2 < R; i++) {
            for (int j = 0; j + 2 < C; j++) {
                int idx = 0;
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        win[idx++] = a[r][c];
                    }
                }
                Arrays.sort(win);
                if (win[4] >= T) cnt++;
            }
        }

        System.out.println(cnt);
    }
}