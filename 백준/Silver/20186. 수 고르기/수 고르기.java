import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[] arr;
    
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(new boolean[N], 0, 0);
        System.out.println(ans);
    }

    private static void backtracking(boolean[] visited, int count, int sum) {
        if (count >= K) {
            ans = Math.max(ans, sum);
            return ;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(visited, count + 1, sum + arr[i] - count);
                visited[i] = false;
            }
        }
    }
}