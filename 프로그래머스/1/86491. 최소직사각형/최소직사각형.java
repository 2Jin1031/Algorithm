import java.util.*;

class Solution {
    
    int N;
    
    public int solution(int[][] sizes) {
        N = sizes.length;
        
        int longLine = 0, shortLine = 0;
        for (int i = 0; i < N; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            longLine = Math.max(longLine, Math.max(w, h));
            shortLine = Math.max(shortLine, Math.min(w, h));
        }
        return longLine * shortLine;
    }
}