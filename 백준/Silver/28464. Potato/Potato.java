import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int middleIdx = N / 2;

        int ans1 = 0;
        for (int i = 0; i < middleIdx; i++) {
            ans1 += arr[i];
        }

        int ans2 = 0;
        for (int i = middleIdx; i < N; i++) {
            ans2 += arr[i];
        }

        System.out.println(ans1 + " " + ans2);
    }
}