import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        
        long ans = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = a;
            ans += b;
        }

        Arrays.sort(arr);

        for (int i = 1; i < N + 1; i++) {
            ans += (long)arr[i - 1] * i;
        }

        System.out.println(ans);
    }
}