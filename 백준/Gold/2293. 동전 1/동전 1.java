import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K + 1];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j <= K; j++) {
                dp[j] += dp[j - arr[i]];
                
            }
        }

        bw.write(dp[K] + "\n");
        bw.close();
        br.close();
    }
}
