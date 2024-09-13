import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int sqrt = (int) Math.sqrt(N);

        for (int i = 1; i < N + 1; i++) {
            dp[i] = i;
        }

        for (int i = 2; i < sqrt + 1; i++) {
            for (int j = i * i; j < N + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        bw.write(dp[N] + "\n");

        bw.close();
        br.close();
    }
}