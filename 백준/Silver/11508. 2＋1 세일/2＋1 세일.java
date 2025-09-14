import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int ans = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            ans += arr[i];
        }

        Arrays.sort(arr);

        int startIdx = N / 3;
        int endIdx = N - N / 3 * 2;

        for (int i = N - 3; i >= 0; i -= 3) {
            ans -= arr[i];
        }

        System.out.println(ans);
    }
}
