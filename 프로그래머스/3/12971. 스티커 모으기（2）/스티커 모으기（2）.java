import java.util.*;

class Solution {
    int[] dp1, dp2;

    public int solution(int sticker[]) {
        int N = sticker.length;
        dp1 = new int[N];
        dp2 = new int[N];
        
        if (N < 2) {
            return sticker[0];
        }
        
        dp1[0] = sticker[0]; dp1[1] = Math.max(sticker[0], sticker[1]);
        dp2[1] = sticker[1];
        
        for (int i = 2; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        
        int result1 = dp1[N - 2];
        int result2 = dp2[N - 1];
        
        return Math.max(result1, result2);
    }
}