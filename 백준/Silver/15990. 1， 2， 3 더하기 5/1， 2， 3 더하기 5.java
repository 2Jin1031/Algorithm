import java.util.Scanner;

public class Main {
    static final int MOD = 1000000009;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int max = 0;
        int[] testCases = new int[T];

        for (int i = 0; i < T; i++) {
            testCases[i] = sc.nextInt();
            if (testCases[i] > max) {
                max = testCases[i];
            }
        }

        long[][] dp = new long[max + 1][4];

        // 초기값 설정
        if (max >= 1) {
            dp[1][1] = 1;
            dp[1][2] = 0;
            dp[1][3] = 0;
        }
        if (max >= 2) {
            dp[2][1] = 0;
            dp[2][2] = 1;
            dp[2][3] = 0;
        }
        if (max >= 3) {
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
        }

        // DP 계산
        for (int i = 4; i <= max; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        // 테스트 케이스 출력
        for (int i = 0; i < T; i++) {
            int n = testCases[i];
            long result = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            System.out.println(result);
        }

        sc.close();
    }
}