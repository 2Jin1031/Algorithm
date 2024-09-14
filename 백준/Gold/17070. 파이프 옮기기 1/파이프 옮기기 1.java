import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N;
    private static int[][] arr;

    private static int[][][] D = {
            {{0, 1, 0}, {1, 1, 2}}, // 가로에서 갈 수 있는 방향: 가로, 대각선
            {{1, 0, 1}, {1, 1, 2}}, // 세로에서 갈 수 있는 방향: 세로, 대각선
            {{1, 0, 1}, {0, 1, 0}, {1, 1, 2}} // 대각선에서 갈 수 있는 방향: 가로, 세로, 대각선
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        if (arr[N - 1][N - 1] == 1) {
            bw.write("0");
            bw.close();
            br.close();
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 1, 0}); // {x, y, 방향(0: 가로, 1: 세로, 2: 대각선)}

        int count = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int direction = current[2];

            if (currentX == N - 1 && currentY == N - 1) {
                count++;
                continue;
            }

            for (int i = 0; i < D[direction].length; i++) {
                int nextX = currentX + D[direction][i][0];
                int nextY = currentY + D[direction][i][1];
                int nextDirection = D[direction][i][2];

                if (isValidCoordinate1(nextX, nextY, nextDirection)) {
                    queue.add(new int[]{nextX, nextY, nextDirection});
                }
            }
        }

        

        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }

    private static boolean isValidCoordinate1(int nextX, int nextY, int direction) {
        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || arr[nextX][nextY] == 1) {
            return false;
        }

        // 대각선으로 이동할 경우, 대각선의 세 칸을 모두 확인해야 함
        if (direction == 2) {
            if (nextX - 1 < 0 || nextY - 1 < 0) {
                return false;
            }
            if (arr[nextX - 1][nextY] == 1 || arr[nextX][nextY - 1] == 1 || arr[nextX - 1][nextY - 1] == 1) {
                return false;
            }
        }

        return true;
    }
}