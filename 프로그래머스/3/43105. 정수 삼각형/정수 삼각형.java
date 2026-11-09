import java.util.*;

class Solution {
    
    int[][] dp;
    
    public int solution(int[][] triangle) {
        int N = triangle.length;
        dp = new int[N][N];
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                int num1 = 0, num2 = 0;
                num1 = j == 0 ? 0 : triangle[i][j] + dp[i - 1][j - 1];
                num2 = j == i ? 0 : triangle[i][j] + dp[i - 1][j];
                
                dp[i][j] = Math.max(num1, num2);
            }
        }
        
        int answer = 0;
        for (int j = 0; j < N; j++) {
            answer = Math.max(answer, dp[N - 1][j]);
        }
        return answer;
    }
}