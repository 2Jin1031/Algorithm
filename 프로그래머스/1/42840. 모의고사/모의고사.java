import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int N = answers.length;
        
        int[] counts = new int[3];
        int[] answers2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] answers3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int maxPass = 0;
        for (int i = 0, answer1 = 1; i < N; i++, answer1 = answer1 % 5 + 1) {
            if (answers[i] == answer1) {
                counts[0]++;
            }
            
            if (answers[i] == answers2[i % 8]) {
                counts[1]++;
            }
            
            if (answers[i] == answers3[i % 10]) {
                counts[2]++;
            }
            
            maxPass = Math.max(maxPass, Math.max(counts[0], Math.max(counts[1], counts[2])));
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (maxPass == counts[i]) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}