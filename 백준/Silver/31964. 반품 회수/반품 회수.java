import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int ans = Math.max(arr[N - 1][0], arr[N - 1][1]);
        for (int i = N - 2; i >= 0; i--) {
            ans += arr[i + 1][0] - arr[i][0];
            if (arr[i][1] > ans) {
                ans = arr[i][1];
            }
        }

        System.out.println(ans + arr[0][0]);
    }
}