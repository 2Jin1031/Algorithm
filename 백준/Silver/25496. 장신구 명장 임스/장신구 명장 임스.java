import java.io.*;
import java.util.*;

public class Main {

    private static int ans = 0;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int rest = 200 - P;

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (rest > 0) {
                ans++;
                rest -= arr[i];
                continue;
            }
            break;
        }

        System.out.println(ans);
    }
}