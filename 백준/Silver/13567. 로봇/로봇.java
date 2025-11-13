import java.io.*;
import java.util.*;

public class Main {
 
    private static int[] DX = {1, 0, -1, 0}; // 왼쪽
    private static int[] DY = {0, 1, 0, -1};

    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int currentX = 0, currentY = 0;
        int dIdx = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (command.equals("MOVE")) {
                int nextX = currentX + num * DX[dIdx];
                int nextY = currentY + num * DY[dIdx];

                if (isValidCoordinate(nextX, nextY)) {
                    currentX = nextX;
                    currentY = nextY;
                } else {
                    System.out.println("-1");
                    return ;
                }
            } else { // "TURN"
                if (num == 0) {// 왼쪽
                    dIdx = (dIdx + 1) % 4;
                } else {
                    dIdx = (dIdx + 3) % 4;
                }
                
            }
        }

        System.out.println(currentX + " " + currentY);
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY < N && nextY >= 0 && nextY < N;
    }
}