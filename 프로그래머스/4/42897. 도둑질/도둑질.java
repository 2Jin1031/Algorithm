class Solution {
    
    int[] dp1, dp2;
    
    public int solution(int[] money) {
        int N = money.length;
        dp1 = new int[N];
        dp2 = new int[N];
        
        dp1[0] = money[0]; dp1[1] = Math.max(money[0], money[1]);
        dp2[1] = money[1];
        
        for (int i = 2; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }
        return Math.max(dp1[N - 2], dp2[N - 1]);
    }
}