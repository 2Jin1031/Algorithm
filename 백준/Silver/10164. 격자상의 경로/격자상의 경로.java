import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, K;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];

        if (K == 0) {
            bw.write(solve(1, 1, N, M) + "\n");
        } else {
            int Kx = (K - 1) / M + 1; 
            int Ky = (K - 1) % M + 1; 
            int result = solve(1, 1, Kx, Ky) * solve(Kx, Ky, N, M);
            bw.write(result + "\n");
        }

        bw.close();
        br.close();
    }

    private static int solve(int startX, int startY, int endX, int endY) {
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (i == startX || j == startY) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[endX][endY];
    }
}