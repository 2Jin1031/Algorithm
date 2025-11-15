import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] arr;
    private static int minAns = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, false);
        System.out.println(minAns);
    }

    private static void dfs(int idx, int totalSour, int totalBitter, boolean isUsed) {
        if (idx >= N) {
            if (isUsed) {
                int ans = Math.abs(totalSour - totalBitter);
                minAns = Math.min(minAns, ans);    
            }
            return ;
        }

        dfs(idx + 1, totalSour * arr[idx][0], totalBitter + arr[idx][1], true);
        dfs(idx + 1, totalSour, totalBitter, isUsed ? true : false);
    }
}