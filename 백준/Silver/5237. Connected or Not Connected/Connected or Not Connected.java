import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());


            List<List<Integer>> arr = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                arr.add(new ArrayList<>());
            }
            for (int i = 0; i < K; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr.get(a).add(b);
                arr.get(b).add(a);
            }

            if (bfs(arr)) {
                System.out.println("Connected.");
            } else {
                System.out.println("Not connected.");
            }
        }
    }

    private static boolean bfs(List<List<Integer>> arr) {
        boolean[] visited = new boolean[arr.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < arr.get(current).size(); i++) {
                int next = arr.get(current).get(i);
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
