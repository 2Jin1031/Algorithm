import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int[] w = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) w[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(w);

        int l = 0, r = N - 1;
        int ans = 0;

        while (l < r) {
            long sum = (long) w[l] + w[r];
            if (sum <= K) {
                ans++;
                l++;
                r--;
            } else {
                r--;
            }
        }

        System.out.println(ans);
    }
}