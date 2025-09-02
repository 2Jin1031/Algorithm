import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        int src = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            int desc = arr[i];
            while (desc >= src) {
                desc--;
                ans++;
            }
            src = desc;
        }
        System.out.println(ans);
    }
}
