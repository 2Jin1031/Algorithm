import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int N = relation.length;     // 행 개수 (학생 수)
        int M = relation[0].length;  // 열 개수 (속성 수)

        List<Integer> keys = new ArrayList<>();
        for (int mask = 1; mask < (1 << M); mask++) {
            
            boolean minimal = true;
            for (int key : keys) {
                if ((key & mask) == key) {
                    minimal = false;
                    break;
                }
            }
            
            if (!minimal) {
                continue;
            }
            
            Set<String> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < M; k++) {
                    if ((mask & (1 << k)) != 0) {
                        sb.append(relation[i][k]).append(", ");
                    }
                }
                set.add(sb.toString());
            }
            
            if (set.size() == N) {
                keys.add(mask);
            }
        }

        return keys.size();
    }
}
