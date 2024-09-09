import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  
        int K = sc.nextInt();  

        int[][] dp = new int[K+1][N+1];
        
        for (int i = 0; i <= K; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= K; i++) {  // 숫자의 개수
            for (int j = 1; j <= N; j++) {  // 합이 되어야 하는 수
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        System.out.println(dp[K][N]);
    }
}