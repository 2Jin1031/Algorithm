import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); 
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken()); 
            }

            int money = Integer.parseInt(br.readLine());

            int[] dp = new int[money + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int j = coin; j <= money; j++) {
                    dp[j] += dp[j - coin];
                }
            }

            bw.write(dp[money] + "\n");
        }

        bw.close();
        br.close();
    }
}