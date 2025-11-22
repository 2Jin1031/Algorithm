import java.io.*;
import java.util.*;

public class Main {

    private static int N, L, R, X;
    private static int[] arr;
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0, Integer.MAX_VALUE, 0, 0);
        System.out.println(ans);
    }

    private static void backtracking(int count, 
                                     int sum, 
                                     int minLevel, 
                                     int maxLevel, 
                                     int idx
                                    ) {
        if (count >= 2) {
            if (sum >= L && sum <=R && maxLevel - minLevel >= X) {
                ans++;
            }
        }

        for (int i = idx; i < arr.length; i++) {
            backtracking(count + 1, sum + arr[i], Math.min(minLevel, arr[i]), Math.max(maxLevel, arr[i]), i + 1);
        }
    }
}