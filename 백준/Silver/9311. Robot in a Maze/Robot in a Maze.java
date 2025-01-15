import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[][] map = new String[N][M];
            boolean[][] visited = new boolean[N][M];
            int[] startPosition = new int[2];
            List<int[]> endPositions = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = String.valueOf(input.charAt(j));
                    if (map[i][j].equals("X")) {
                        visited[i][j] = true;
                    }
                    else if (map[i][j].equals("S")) {
                        startPosition[0] = i;
                        startPosition[1] = j;
                    }
                    else if (map[i][j].equals("G")) {
                        int[] endPosition = {i, j};
                        endPositions.add(endPosition);
                    }
                }
            }

            int result = BFS(map, visited, startPosition, endPositions);
            if (result != -1) {
                System.out.println("Shortest Path: " + result);
            } else {
                System.out.println("No Exit");
            }
        }
    }

    private static int BFS(String[][] map, boolean[][] visited, int[] startPosition, List<int[]> endPositions) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startPosition[0], startPosition[1], 0});
        visited[startPosition[0]][startPosition[1]] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (map[x][y].equals("G")) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, count + 1});
            }
        }
        return -1;
    }
}