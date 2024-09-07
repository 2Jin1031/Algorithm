import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            dp[i] = arr[1] * i;
        }


        for (int i = 2; i < N + 1; i++) {
            for (int j = i; j < N + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - i] + arr[i]);
            }
        }

        bw.write(dp[N] + "\n");

        bw.close();
        br.close();

    }
}