import java.io.*;
import java.util.*;

public class Main {
    private static int F, S, G, U, D;
    private static int[] map;
    private static boolean[] visited;

    private final static int[] DX = {0, 0, 1, -1};
    private final static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        bfs(S);

        if (visited[G]) {
            bw.write(map[G] + "\n");
        } else {
            bw.write("use the stairs\n");
        }
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[F + 1];
        visited = new boolean[F + 1];
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        map[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == G) {
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = current + (i == 0 ? U : -D);

                if (isValidCoordinate(next) && !visited[next]) {
                    map[next] = map[current] + 1;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

    }

    private static boolean isValidCoordinate(int next) {
        return next >= 1 && next <= F;
    }
}