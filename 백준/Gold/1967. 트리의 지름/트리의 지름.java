import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<int[]>> tree = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            tree.get(a).add(new int[]{b, w});
            tree.get(b).add(new int[]{a, w});
        }

        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        dfs(tree, dist, visited, 1, 0);
        int max = 0;
        int idx = 0;
        for (int j = 1; j <= N; j++) {
            if (dist[j] > max) {
                max = dist[j];
                idx = j;
            }
        }
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(tree, dist, visited, idx, 0);
        max = 0;
        for (int j = 1; j <= N; j++) {
            if (dist[j] > max) {
                max = dist[j];
            }
        }
        System.out.println(max);
        
    }

    private static void dfs(ArrayList<ArrayList<int[]>> tree, int[] dist, boolean[] visited, int i, int i1) {
        visited[i] = true;
        for (int[] next : tree.get(i)) {
            if (!visited[next[0]]) {
                dist[next[0]] = dist[i] + next[1];
                dfs(tree, dist, visited, next[0], next[1]);
            }
        }
    }
}