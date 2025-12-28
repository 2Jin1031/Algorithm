import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        long sumTopK = 0;
        for (int i = N - 1; i >= N - K; i--) sumTopK += a[i];

        long penalty = (long) K * (K - 1) / 2;
        long ans = sumTopK - penalty;

        System.out.println(ans);
    }
}