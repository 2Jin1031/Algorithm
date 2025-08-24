import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static int N, M;
    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        int[] startPosition = new int[2];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
                if (arr[i][j] == 'X') {
                    visited[i][j] = true;
                    continue;
                }
                else if (arr[i][j] == 'I') {
                    startPosition[0] = i;
                    startPosition[1] = j;
                    continue;
                }
            }
        }

        int ans = BFS(arr, visited, startPosition);
        if (ans == 0) {
            bw.write("TT");
        } else {
            bw.write(String.valueOf(ans));
        }
        
        bw.flush();
        bw.close();
    }

    private static int BFS(char[][] arr, boolean[][] visited, int[] startPosition) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(startPosition);
        visited[startPosition[0]][startPosition[1]] = true;

        int peopleCount = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;

                    if (arr[nextX][nextY] == 'P') peopleCount++;
                }
            }
        }
        return peopleCount;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M;
    }
}
