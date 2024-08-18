import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        bw.write(String.valueOf(bfs()));

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                return visited[current] - 1;
            }
            move(queue, current, current * 2, 0);
            move(queue, current, current - 1, 1);
            move(queue, current, current + 1, 1);
        }
        return -1;
    }

    private static void move(Queue<Integer> queue, int currentPosition, int newPosition, int timeIncrease) {
        if (isValidPosition(newPosition) && !isVisited(newPosition)) {
            queue.add(newPosition);
            visited[newPosition] = visited[currentPosition] + timeIncrease;
        }
    }

    private static boolean isValidPosition(int position) {
        return position >= 0 && position <= 100000;
    }

    private static boolean isVisited(int position) {
        return visited[position] != 0;
    }
}
