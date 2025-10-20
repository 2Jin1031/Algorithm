import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int maxX = 0, maxY = 0;
        boolean[][] map = new boolean[501][501];
        StringTokenizer st;
        for (int loop = 0; loop < N; loop++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    map[i][j] = true;
                }
            }

            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);
        }

        int ans = 0;
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                if (map[i][j]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}