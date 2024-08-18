import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[] visited = new int[100001];
    private static int minTime = Integer.MAX_VALUE;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        bfs();
        bw.write(minTime + "\n" + count);

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1; 

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                if (visited[current] - 1 < minTime) {
                    minTime = visited[current] - 1;
                    count = 1;
                } else if (visited[current] - 1 == minTime) {
                    count++;
                }
            }

            int[] nextPositions = {current * 2, current - 1, current + 1};
            for (int next : nextPositions) {
                if (isValidPosition(next)) {
                    if (visited[next] == 0 || visited[next] == visited[current] + 1) {
                        queue.add(next);
                        visited[next] = visited[current] + 1;
                    }
                }
            }
        }
    }

    private static boolean isValidPosition(int position) {
        return position >= 0 && position <= 100000;
    }
}