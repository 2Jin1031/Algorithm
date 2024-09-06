import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[2][N];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], 1);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxValue = 1;
        for (int i = N - 2; i >= 0; i--) {
            int j = i + 1;
                if (arr[i] == arr[j]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
                    dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
                }
                if (arr[i] < arr[j]) { // 오름차순 0
                    dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
                }
                if (arr[i] > arr[j]) { // 내림차순 1
                    dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
                }
            maxValue = Math.max(maxValue, Math.max(dp[0][i], dp[1][i]));
        }
        bw.write(maxValue + "\n");

        bw.close();
        br.close();

    }
}