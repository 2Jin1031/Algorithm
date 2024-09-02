import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] maze;
    private static boolean[] visited;

    private static int[] jump;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        int minJump = BFS(0);

        bw.write(minJump + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {

        N = Integer.parseInt(br.readLine());

        maze = new int[N];
        visited = new boolean[N];
        jump = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        jump[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == N - 1) {
                return jump[current];
            }

            int jumpEnd = current + maze[current];
            for (int next = current + 1; next <= jumpEnd; next++) {
                if (isValidCoordinate(next) && !visited[next]) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                        jump[next] = jump[current] + 1;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValidCoordinate(int next) {
        return next >= 0 && next < N;
    }
}