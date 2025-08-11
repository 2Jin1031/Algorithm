import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited, finished;
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];

        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) dfs(i);
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    static void dfs(int x) {
        visited[x] = true;
        int next = arr[x];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int i = next; ; i = arr[i]) {
                ans.add(i);
                if (i == x) break;
            }
        }
        finished[x] = true;
    }
}