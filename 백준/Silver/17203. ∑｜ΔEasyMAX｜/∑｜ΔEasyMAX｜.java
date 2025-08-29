import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N]; 
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sumArr = new int[N];
        for (int i = 1; i < N; i++) {
            sumArr[i] = Math.abs(arr[i] - arr[i - 1]);
        }
    
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ans = 0;
            for (int j = start; j < end; j++) {
                ans += sumArr[j];
            }
            System.out.println(ans);
        }
    }
}