import java.util.*;

class Solution {
    
    
    int N;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        dfs(k, new boolean[N], 0, dungeons);
        return answer;
    }
    
    public void dfs(int restK, boolean[] visited, int count, int[][] dungeons) {
        answer = Math.max(answer, count);
        if (count > N) {
            return ;
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            int minRestK = dungeons[i][0];
            int useK = dungeons[i][1];

            if (restK < minRestK) {
                continue;
            }
            
            visited[i] = true;
            dfs(restK - useK, visited, count + 1, dungeons);
            visited[i] = false;
        }
    }
}