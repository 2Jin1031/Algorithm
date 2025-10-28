import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = backtracking("", new boolean[N], 0);
        
        System.out.print(sb);
    }

    private static StringBuilder backtracking(String str, boolean[] visited, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            return sb.append(str).append("\n");
        }

        StringBuilder totalSb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            StringBuilder localSb = backtracking(str + (i + 1) + " ", visited, depth + 1);
            totalSb.append(localSb);
            visited[i] = false;
        }

        return totalSb;
    }
}
