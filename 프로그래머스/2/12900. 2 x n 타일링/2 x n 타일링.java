class Solution {
    
    int[] dp;
    
    public int solution(int n) {
        dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2;
        
        
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        
        
        return dp[n];
    }
}