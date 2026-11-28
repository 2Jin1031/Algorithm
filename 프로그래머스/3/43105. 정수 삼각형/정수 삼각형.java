import java.util.*;

class Solution {
    
    int N;
    int[][] dp;
    public int solution(int[][] triangle) {
        N = triangle.length;
        dp = new int[N][N];
        
        dp[0][0] = triangle[0][0];
        
        int answer = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) dp[i][j] = triangle[i][j] + dp[i - 1][j];
                else dp[i][j] = Math.max(triangle[i][j] + dp[i - 1][j - 1], triangle[i][j] + dp[i - 1][j]);
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer;
    }
}