import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] arr;
    private static int[] ans;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        ans = new int[M];
        backtracking(0, 0);
        System.out.print(sb.toString());
    }

    private static void backtracking(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            ans[depth] = arr[i];
            backtracking(depth + 1, i);
        }
    }
}