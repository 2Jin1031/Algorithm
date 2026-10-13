class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    int H = 0; // 세로
    int W = 0; // 가로
    
    public int findDirectionIdx(String directStr) {
        if (directStr.equals("E")) {
            return 0;
        } else if (directStr.equals("S")) {
            return 1;
        } else if (directStr.equals("W")) {
            return 2;
        } else if (directStr.equals("N")) {
            return 3;
        } 
        return -999;
    }
    
    public boolean isValidCoordinate (int nextX, int nextY) {
        if (nextX < 0 || nextX >= H || nextY < 0 || nextY >= W) {
            return false;
        }
        return true;
    }
        
    
    public int[] solution(String[] park, String[] routes) {
        H = park.length;
        W = park[0].length();
        int[] startPosition = new int[2];
        String[][] map = new String[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0;  j < W; j++) {
                map[i][j] = park[i].charAt(j) + "";
                if (map[i][j].equals("S")) {
                    startPosition[0] = i;
                    startPosition[1] = j;
                }
            }
        }
        
        int currentX = startPosition[0];
        int currentY = startPosition[1];
        for (int idx = 0; idx < routes.length; idx++) {
            String[] routePart = routes[idx].split(" ");
            String directStr = routePart[0];
            int num = Integer.parseInt(routePart[1]);
            
            int dirIdx = findDirectionIdx(directStr);
            
            int nextX = currentX + dx[dirIdx] * num;
            int nextY = currentY + dy[dirIdx] * num;
            
            if (isValidCoordinate(nextX, nextY)) {
                int i = currentX, j = currentY;
                boolean flag = true;
                while (num > 0) {
                    i += dx[dirIdx];
                    j += dy[dirIdx];
                    System.out.println("!");
                    if (map[i][j].equals("X")) {
                        flag = false;
                        break;
                    }
                    num--;
                }
                
                if (flag) {
                    currentX = nextX;
                    currentY = nextY;
                }
                
            }
            
        }
        
        return new int[]{currentX, currentY};
    }
}