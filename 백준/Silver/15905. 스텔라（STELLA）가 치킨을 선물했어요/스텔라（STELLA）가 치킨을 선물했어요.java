import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator
            .<int[]>comparingInt(r -> -r[0])  
            .thenComparingInt(r -> r[1])); 

        int value = arr[4][0];

        int ans = 0;
        for (int i = 5; i < N; i++) {
            if (value != arr[i][0]) {
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }
}