import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp 초기화
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        // dp 계산
        for (int i = N - 1; i >= 0; i--) { // 기준 요소 값
            for (int j = i; j < N; j++) { // 기준 요소 다음 요소부터 끝까지
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // 최대값 찾기
        int maxSum = dp[0];
        for (int i = 1; i < N; i++) {
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }

        bw.write(String.valueOf(maxSum));

        bw.close();
        br.close();
    }
}