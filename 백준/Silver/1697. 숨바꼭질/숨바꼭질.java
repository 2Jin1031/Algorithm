import java.io.*;
import java.util.*;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        Queue<Integer> queue  = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == K) {
                bw.write(String.valueOf(visited[x] - 1));
                bw.close();
                return;
            }

            if (x - 1 >= 0 && visited[x - 1] == 0) {
                queue.add(x - 1);
                visited[x - 1] = visited[x] + 1;
            }

            if (x + 1 <= 100000 && visited[x + 1] == 0) {
                queue.add(x + 1);
                visited[x + 1] = visited[x] + 1;
            }

            if (x * 2 <= 100000 && visited[x * 2] == 0) {
                queue.add(x * 2);
                visited[x * 2] = visited[x] + 1;
            }
        }
    }
}
