import java.lang.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 4; i <= n; i++) {
            if (isHap(i)) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isHap(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }
}