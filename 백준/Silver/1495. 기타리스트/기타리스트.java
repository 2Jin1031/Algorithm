import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, S, M;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        dp = new int[N + 1][M + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int j = S; j <= M; j++) {
            dp[0][j] = S;
        }

        for (int i = 0; i < N; i++) {
            for (int j = M; j >= 0; j--) {
                if (dp[i][j] == -1) {
                    continue;
                }
                if (dp[i][j] + arr[i + 1] <= M) {
                    dp[i + 1][dp[i][j] + arr[i + 1]] = Math.max(dp[i + 1][dp[i][j] + arr[i + 1]], dp[i][j] + arr[i + 1]);
                }
                if (dp[i][j] - arr[i + 1] >= 0) {
                    dp[i + 1][dp[i][j] - arr[i + 1]] = Math.max(dp[i + 1][dp[i][j] - arr[i + 1]], dp[i][j] - arr[i + 1]);
                }
            }
        }

        int answer = -1;
        for (int i = 0; i <= M; i++) {
            answer = Math.max(answer, dp[N][i]);
        }

        bw.write(answer + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}