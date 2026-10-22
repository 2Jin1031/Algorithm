import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : scoville) {
            pq.offer(num);
        }
        
        int count = 0;
        int num1 = 0;
        while (!pq.isEmpty()) {
            num1 = pq.poll();
            Integer num2 = pq.poll();
            if (num1 < K && num2 != null) {
                pq.offer(num1 + num2 * 2);
                count++;
            } else {
                break;
            }
        }
        
        int answer = 0;
        if (num1 < K) {
            answer = -1;
        } else {
            answer = count;
        }
        
        return answer;
    }
}