import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        dist[N] = 0;
        queue.add(N);

        int ans = 0;
        while (!queue.isEmpty()) {
            int currentN = queue.poll();
            if (currentN == M) {
                ans = dist[currentN];
                break;
            }
            int nextCount = dist[currentN] + 1;

            int[] nextD = new int[] {
                currentN - 1, currentN + 1,
                currentN - A, currentN + A,
                currentN - B, currentN + B,
                currentN * A, currentN * B
            };

            for (int next : nextD) {
                if (next < 0 || next > 100000) continue;
                if (dist[next] != -1) continue;
                dist[next] = nextCount;
                queue.add(next);
            }
        }

        System.out.println(ans);
    }
}