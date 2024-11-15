import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[K + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});
        visited[N] = true;

        int result = -1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == K) {
                result = current[1];
                break;
            }

            if (current[0] + 1 < K + 1 && !visited[current[0] + 1]) {
                queue.offer(new int[]{current[0] + 1, current[1] + 1});
                visited[current[0] + 1] = true;
            }
            if (current[0] * 2 < K + 1 && !visited[current[0] * 2]) {
                queue.offer(new int[]{current[0] * 2, current[1] + 1});
                visited[current[0] * 2] = true;
            }
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}