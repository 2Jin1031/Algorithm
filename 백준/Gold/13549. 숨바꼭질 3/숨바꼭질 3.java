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

        bfs(bw);

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

    }

    private static void bfs(BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                bw.write(String.valueOf(visited[current] - 1));
                bw.close();
            }
            if (current * 2 <= 100000 && visited[current * 2] == 0) {
                queue.add(current * 2);
                visited[current * 2] = visited[current];
            }
            if (current -1 >= 0 && visited[current - 1] == 0) {
                queue.add(current - 1);
                visited[current - 1] = visited[current] + 1;
            }
            if (current + 1 <= 100000 && visited[current + 1] == 0) {
                queue.add(current + 1);
                visited[current + 1] = visited[current] + 1;
            }
        }
    }
}
