import java.io.*;

public class Main {
    private static int T;
    private static int[] testCases;
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        testCases = new int[T];
        int maxTestCase = 0;

        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
            maxTestCase = Math.max(maxTestCase, testCases[i]);
        }

        int[] dp = new int[maxTestCase + 1];

        dp[1] = 1;
        if (maxTestCase > 1) dp[2] = 2;
        if (maxTestCase > 2) dp[3] = 4;

        for (int i = 4; i <= maxTestCase; i++) {
            dp[i] = ((dp[i-1] + dp[i-2]) % MOD + dp[i-3]) % MOD;
        }

        for (int i = 0; i < T; i++) {
            bw.write(dp[testCases[i]] + "\n");
        }

        bw.close();
        br.close();
    }
}