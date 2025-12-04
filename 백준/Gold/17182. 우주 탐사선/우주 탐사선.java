import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] arr;

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); 

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int FULL = (1 << N) - 1;
        int[][] dp = new int[1 << N][N];
        for (int i = 0; i < (1 << N); i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[1 << K][K] = 0;

        for (int mask = 0; mask <= FULL; mask++) {
            for (int u = 0; u < N; u++) {
                if (dp[mask][u] == INF) continue;
                for (int v = 0; v < N; v++) {
                    int nmask = mask | (1 << v);
                    int nextCost = dp[mask][u] + arr[u][v];
                    if (dp[nmask][v] > nextCost) {
                        dp[nmask][v] = nextCost;
                    }
                }
            }
        }

        int ans = INF;
        for (int i = 0; i < N; i++) {
            ans = Math.min(ans, dp[FULL][i]);
        }

        System.out.println(ans);
    }
}