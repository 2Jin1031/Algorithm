import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] arr;
    private static boolean[] visited;

    private static int startPosition;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        bfs(startPosition - 1);

        int count = 0;
        for (boolean visit : visited) {
            if (visit) {
                count++;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        startPosition = Integer.parseInt(br.readLine());
    }

    private static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        visited[idx] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int rightJump = current + arr[current];
            if (isCorrectPosition(rightJump) && !visited[rightJump]) {
                queue.offer(rightJump);
                visited[rightJump] = true;
            }
            int leftJump = current - arr[current];
            if (isCorrectPosition(leftJump) && !visited[leftJump]) {
                queue.offer(leftJump);
                visited[leftJump] = true;
            }
        }
    }

    private static boolean isCorrectPosition(int position) {
        return position >= 0 && position < N;
    }
}