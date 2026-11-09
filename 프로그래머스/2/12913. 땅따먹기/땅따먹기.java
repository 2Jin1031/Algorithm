import java.util.*;

class Solution {
    
    int[][] dp;
    
    int solution(int[][] land) {
        dp = new int[land.length][4];
        
        int fmv = 0;
        int fmi = 0;
        int smv = 0;
        int smi = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (fmi == j) {
                    dp[i][j] += land[i][j] + smv;    
                } else {
                    dp[i][j] += land[i][j] + fmv;
                }
            }
            
            fmv = 0;
            fmi = 0;
            smv = 0;
            smi = 0;
            for (int j = 0; j < 4; j++) {
                if (fmv < dp[i][j]) {
                    smv = fmv;
                    smi = fmi;
                    fmv = dp[i][j];
                    fmi = j;
                } else if (smv < dp[i][j]) {
                    smv = dp[i][j];
                    smi = j;
                }
            }
        }

        return fmv;
    }
}