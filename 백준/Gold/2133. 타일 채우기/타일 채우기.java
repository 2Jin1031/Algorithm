import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        if (N >= 2) dp[2] = 3;
        if (N >= 4) dp[4] = 11;
        for (int i = 6; i <= N; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 2; j -= 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] += 2;
        }

        bw.write(dp[N] + "\n");

        bw.close();
        br.close();
    }

}