import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());            
        }

        Arrays.sort(arr);

        int count = M * K;
        int i;
        for (i = N - 1; i >= 0; i--) {
            count -= arr[i];
            if (count <= 0) {
                break;
            }
        }

        if (count > 0) {
            System.out.println("STRESS");
        } else {
            System.out.println(N - i);    
        }
    }
}