import java.lang.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int longer = Math.max(sides[0], sides[1]);
        int shorter = Math.min(sides[0], sides[1]);
        
        // 이미 가장 긴 변이 있을 경우
        for (int i = longer - 1; i + shorter > longer; i--) {
            answer++;
        }

        // 가장 긴 변이 될 경우
        for (int i = longer; longer + shorter > i; i++) {
            answer++;
        }

        return answer;
    }
}