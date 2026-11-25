import java.util.*;

class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    int N, M;
    boolean[][] visited;
    
    int[] arr;
    
    public int solution(int[][] land) {
        N = land.length; M = land[0].length;
        
        arr = new int[M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] info = BFS(i, j, land);
                    int startCol = info[0];
                    int endCol = info[1];
                    int size = info[2];
                    for (int col = startCol; col <= endCol; col++) {
                        arr[col] += size;
                        
                    }
                }
            }
        }
        
        int answer = 0;
        for (int col = 0; col < M; col++) {
            answer = Math.max(answer, arr[col]);
        }
        
        return answer;
    }
    
    public int[] BFS (int x, int y, int[][] land) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        int size = 0;
        int startCol = M, endCol = 0;
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            
            startCol = Math.min(startCol, currentY);
            endCol = Math.max(endCol, currentY);
            
            size++;
            
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                if (!isValidCoordinate(nextX, nextY) || visited[nextX][nextY] || land[nextX][nextY] != 1) {
                    continue;
                }
                
                queue.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
        
        return new int[]{startCol, endCol, size};
    }
    
    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}