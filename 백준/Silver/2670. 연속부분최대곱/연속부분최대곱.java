import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        double[] dp = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        System.arraycopy(arr, 0, dp, 0, N);

        double max = 0;
        for (int i = N - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i], dp[i] * dp[i + 1]);
            max = Math.max(max, dp[i]);
        }

        bw.write(String.format("%.3f", max));
        bw.close();
        br.close();
    }
}