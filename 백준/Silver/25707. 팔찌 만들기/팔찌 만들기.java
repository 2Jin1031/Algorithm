import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = 0;
        for (int i = 2; i < N; i++) {
            ans += arr[i] - arr[i - 2];
        }

        ans += arr[1] - arr[0] + arr[N - 1] - arr[N - 2];

        System.out.println(ans);
    }
}