import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[] arr;
    private static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(500, new boolean[N], 0);
        
        System.out.println(result);
    }
    
    private static void dfs(int currentWeight, boolean[] visited, int depth) {
        if (depth == N) {
            result++;
            return;
        }
    
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            
            int nextWeight = currentWeight + arr[i] - K;
            if (nextWeight < 500) continue;
            
            visited[i] = true;
            dfs(nextWeight, visited, depth + 1);
            visited[i] = false;
        }
    }
}