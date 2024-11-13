import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static Character[][] arr;
    private static boolean[][] visited;

    private static int[] startPosition = new int[2];

    private static int[][] fireDistances;
    private static int[][] personDistances;
    private static ArrayList<int[]> fires = new ArrayList<>();

    private static final int[] DX = {1, 0, 0, -1};
    private static final int[] DY = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            initialization(br);
            fireBFS();
            int result = personBFS(startPosition[0], startPosition[1]);
            bw.write(result == -1 ? "IMPOSSIBLE\n" : result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        fires.clear();  // fires 리스트 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new Character[N][M];
        visited = new boolean[N][M];
        fireDistances = new int[N][M];
        personDistances = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == '#') {
                    visited[i][j] = true;
                } else if (arr[i][j] == '@') {
                    startPosition[0] = i;
                    startPosition[1] = j;
                } else if (arr[i][j] == '*') {
                    fires.add(new int[]{i, j});
                    fireDistances[i][j] = 0;  // 불의 초기 위치 거리를 0으로 설정
                } else {
                    fireDistances[i][j] = Integer.MAX_VALUE; // 불이 닿지 않는 곳은 최대값으로 초기화
                }
            }
        }
    }

    private static void fireBFS() {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] fire : fires) {
            queue.offer(fire);
            visited[fire[0]][fire[1]] = true;  // 불 위치 방문 처리
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    fireDistances[nextX][nextY] = fireDistances[currentX][currentY] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static int personBFS(int startX, int startY) {
        visited = new boolean[N][M];  // 사람 BFS용으로 visited 배열 재설정
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        personDistances[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 가장자리 도달 시 탈출
            if (currentX == 0 || currentY == 0 || currentX == N - 1 || currentY == M - 1) {
                return personDistances[currentX][currentY] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + DX[i];
                int nextY = currentY + DY[i];

                if (isValidCoordinate(nextX, nextY) && !visited[nextX][nextY] && (fireDistances[nextX][nextY] > personDistances[currentX][currentY] + 1)) {
                    visited[nextX][nextY] = true;
                    personDistances[nextX][nextY] = personDistances[currentX][currentY] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }
}