import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static Map<Integer, int[]> map;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] values = new int[N];
            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());

                int idx = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                values[idx - 1] = value;
            }
            map.put(i, values);
        }

        backtracking(0, 0, arr, new boolean[N]);
        System.out.println(ans);
    }

    private static void backtracking(int count, int totalPrice, int[] prices, boolean[] visited) {
        if (count == N) {
            ans = Math.min(ans, totalPrice);
            return ;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int[] values = map.get(i);
                for (int j = 0; j < N; j++) {
                    prices[j] -= values[j];
                }
                backtracking(count + 1, totalPrice + (prices[i] <= 0 ? 1 : prices[i]), prices, visited);
                for (int j = 0; j < N; j++) {
                    prices[j] += values[j];
                }
                visited[i] = false;
            }
        }
    }
}