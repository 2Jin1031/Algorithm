import java.io.*;
import java.util.*;

class Point {
    int rx, ry, bx, by, depth;

    public Point(int rx, int ry, int bx, int by, int depth) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.depth = depth;
    }
}

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static Point start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                }
            }
        }

        start = new Point(rx, ry, bx, by, 0);
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.rx][start.ry][start.bx][start.by] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.depth >= 10) return -1; // 10번 초과 시 실패

            for (int i = 0; i < 4; i++) {
                int nrx = cur.rx, nry = cur.ry, nbx = cur.bx, nby = cur.by;
                boolean redHole = false, blueHole = false;

                // 빨간 구슬 이동
                while (board[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];
                    if (board[nrx][nry] == 'O') {
                        redHole = true;
                        break;
                    }
                }

                // 파란 구슬 이동
                while (board[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];
                    if (board[nbx][nby] == 'O') {
                        blueHole = true;
                        break;
                    }
                }

                // 파란 구슬이 구멍에 빠지면 실패
                if (blueHole) continue;
                // 빨간 구슬만 구멍에 빠지면 성공
                if (redHole) return cur.depth + 1;

                // 같은 위치일 경우, 이동 거리에 따라 조정
                if (nrx == nbx && nry == nby) {
                    if (Math.abs(nrx - cur.rx) + Math.abs(nry - cur.ry) > Math.abs(nbx - cur.bx) + Math.abs(nby - cur.by)) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                // 방문 체크 후 큐에 삽입
                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    queue.add(new Point(nrx, nry, nbx, nby, cur.depth + 1));
                }
            }
        }
        return -1; // 탈출 불가능
    }
}