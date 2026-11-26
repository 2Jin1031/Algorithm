import java.util.*;

class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    int N, M;
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        N = maps.length; M = maps[0].length;
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        
        int answer = BFS(0, 0);
        return answer;
    }
    
    public int BFS(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 1});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentCount = current[2];
            
            if (currentX == N - 1 && currentY == M - 1) {
                return currentCount;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                if (!isValidCoordinate(nextX, nextY) || visited[nextX][nextY]) {
                    continue;
                }
                
                queue.offer(new int[]{nextX, nextY, currentCount + 1});
                visited[nextX][nextY] = true;
            }
        }
        
        return -1;
    }
    
    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}