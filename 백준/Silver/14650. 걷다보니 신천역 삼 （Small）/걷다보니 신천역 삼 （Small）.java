import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        

        long[][] dp = new long[N + 1][3];
        
        dp[1][1] = 1;
        dp[1][2] = 1;
        
        
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] += dp[i - 1][j];
                
                dp[i][j] += dp[i - 1][(j - 1 + 3) % 3];
                
                dp[i][j] += dp[i - 1][(j - 2 + 3) % 3];
            }
        }
        
    
        System.out.println(dp[N][0]);
    }
}

