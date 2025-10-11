import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[101][101];
        int minX = Integer.MAX_VALUE, maxX = 0, minY = Integer.MAX_VALUE, maxY = 0;
        for (int loop = 0; loop < N; loop++) {
            st = new StringTokenizer(br.readLine());
            int aX = Integer.parseInt(st.nextToken());
            int aY = Integer.parseInt(st.nextToken());
            int bX = Integer.parseInt(st.nextToken());
            int bY = Integer.parseInt(st.nextToken());

            minX = Math.min(minX, aX);
            minY = Math.min(minY, aY);
            maxX = Math.max(maxX, bX);
            maxY = Math.max(maxY, bY);
            for (int i = aX; i <= bX; i++) {
                for (int j = aY; j <= bY; j++) {
                    arr[i][j]++;
                }
            }
        }

        int ans = 0;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (arr[i][j] > M) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}