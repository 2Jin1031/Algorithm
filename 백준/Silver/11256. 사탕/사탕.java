import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                arr[i] = R * C;
            }

            Arrays.sort(arr);

            int ans = 0;
            for (int i = N - 1; i >= 0; i--) {
                J -= arr[i];
                if (J <= 0) {
                    ans = N - i;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}