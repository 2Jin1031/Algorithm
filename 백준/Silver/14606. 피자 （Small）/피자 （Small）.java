import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 0;
        if (N > 1) dp[2] = 1;
        for (int i = 2; i < N + 1; i++) {
            int v1 = i / 2;
            int v2 = i - v1;
            dp[i] = v1 * v2 + dp[v1] + dp[v2];
        }

        bw.write(dp[N] + "\n");

        bw.close();
        br.close();
    }
}