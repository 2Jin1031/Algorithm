import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] dp = new int[t + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= t; i++) {
            if (i >= n && dp[i - n] != -1) dp[i] = Math.max(dp[i], dp[i - n] + 1);
            if (i >= m && dp[i - m] != -1) dp[i] = Math.max(dp[i], dp[i - m] + 1);
        }

        int bestTime = 0, bestBurgers = 0;
        for (int i = 0; i <= t; i++) {
            if (dp[i] == -1) continue;
            int colaA = t - i, colaB = t - bestTime;
            if (colaA < colaB || (colaA == colaB && dp[i] > bestBurgers)) {
                bestTime = i;
                bestBurgers = dp[i];
            }
        }

        System.out.println(bestBurgers + " " + (t - bestTime));
    }
}