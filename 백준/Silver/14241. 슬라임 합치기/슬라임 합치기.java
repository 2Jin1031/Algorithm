import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        long score = 0;
        long s = a[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            score += s * a[i];
            s += a[i];
        }
        System.out.println(score);
    }
}