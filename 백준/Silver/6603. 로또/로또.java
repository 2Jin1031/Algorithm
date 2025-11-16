import java.io.*;
import java.util.*;

public class Main {

    private static int K;
    private static int[] arr;
    private static StringBuilder ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;

            arr = new int[K];
            for (int i = 0; i < K; i++) arr[i] = Integer.parseInt(st.nextToken());

            ans = new StringBuilder();
            dfs(0, new StringBuilder(), new boolean[K], -1);
            System.out.print(ans);
            System.out.print('\n');
        }
    }

    private static void dfs(int count, StringBuilder localSb, boolean[] visited, int idx) {
        if (count == 6) {
            ans.append(localSb.substring(1)).append('\n');
            return;
        }

        for (int i = idx + 1; i < K; i++) {
            if (visited[i]) continue; 
            visited[i] = true;

            int len = localSb.length();
            localSb.append(' ').append(arr[i]);

            dfs(count + 1, localSb, visited, i);

            localSb.setLength(len);
            visited[i] = false;
        }
    }
}