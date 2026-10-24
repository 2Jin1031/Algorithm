import java.util.*;

class Solution {
    int answer;
    boolean[] visited;
    int[][] dungeons;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        this.answer = 0;

        re(0, k);
        return answer;
    }

    public void re(int count, int localK) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (localK < dungeons[i][0]) continue;  // 최소 필요 피로도 미달

            visited[i] = true;
            re(count + 1, localK - dungeons[i][1]);
            visited[i] = false;
        }
    }
}