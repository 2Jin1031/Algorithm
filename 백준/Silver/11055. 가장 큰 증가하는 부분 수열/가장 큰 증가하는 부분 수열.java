import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }


        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        // max(dp) 출력
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }

        bw.write(String.valueOf(maxValue));

        br.close();
        bw.close();
    }
}