import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // logic
        int ans = 0;
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            int value = dfs(0, visited, 1, arr[i]);
            ans = Math.max(ans, value);
        }
        
        System.out.println(ans);
    }
    
    private static int dfs(int sum, boolean[] visited, int depth, int lastlyValue) {
        if (depth == N) {
            return sum;
        }

        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            int nextSum = sum + Math.abs(lastlyValue - arr[i]);
            maxSum = Math.max(maxSum, dfs(nextSum, visited, depth + 1, arr[i]));
            visited[i] = false;
        }

        return maxSum;
    }
}