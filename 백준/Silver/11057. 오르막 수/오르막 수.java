import java.io.*;

public class Main {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][11];

        // init dp[1]
        int sum = 0;
        for (int i = 0; i < 10; i ++) {
            dp[1][i] = 10 - i;
            sum += dp[1][i];
        }
        dp[1][10] = sum % 10007;

        for (int i = 2; i < N + 1; i++) {
            sum = dp[i - 1][10];
            dp[i][0] = sum;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] - dp[i - 1][j - 1] + 10007) % 10007;
                sum = (sum + dp[i][j]) % 10007;
            }
            dp[i][10] = sum;
        }

        bw.write(dp[N][0] + "\n");
        bw.close();
        br.close();
    }

}