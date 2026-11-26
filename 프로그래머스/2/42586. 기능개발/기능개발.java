import java.util.*;

class Solution {
    
    int N;
    public int[] solution(int[] progresses, int[] speeds) {
        N = progresses.length;
        List<Integer> list = new ArrayList<>();
        
        int maxPeriod = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int left = 100 - progresses[i];
            int speed = speeds[i];
            int result = (left / speed) + (left % speed != 0 ? 1 : 0);
            
            if (maxPeriod == 0) {
                count++;
                maxPeriod = result;
                continue;
            }
            
            if (maxPeriod < result) {
                list.add(count);
                maxPeriod = result;
                count = 1;
            } else {
                count++;
            }
        }
        list.add(count);
        
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
}