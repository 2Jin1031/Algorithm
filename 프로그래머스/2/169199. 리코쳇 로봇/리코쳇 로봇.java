import java.util.*;

record Pos(int x, int y) {}

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int N, M;
    static char[][] grid;

    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        grid = new char[N][M];

        Pos start = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = board[i].charAt(j);
                if (grid[i][j] == 'R') {
                    start = new Pos(i, j);
                }
            }
        }
        return BFS(start);
    }

    public int BFS(Pos start) {
        int[][] dist = new int[N][M];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start.x()][start.y()] = 0;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            if (grid[cur.x()][cur.y()] == 'G') {
                return dist[cur.x()][cur.y()];
            }

            for (int i = 0; i < 4; i++) {
                Pos next = slide(cur, i);
                if (dist[next.x()][next.y()] != -1) {
                    continue;
                }
                dist[next.x()][next.y()] = dist[cur.x()][cur.y()] + 1;
                queue.add(next);
            }
        }
        return -1;
    }

    public Pos slide(Pos from, int directIdx) {
        int x = from.x(), y = from.y();
        while (true) {
            int nx = x + dx[directIdx];
            int ny = y + dy[directIdx];
            if (!isValidCoordinate(nx, ny) || grid[nx][ny] == 'D') {
                break;
            }
            x = nx;
            y = ny;
        }
        return new Pos(x, y);
    }

    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}