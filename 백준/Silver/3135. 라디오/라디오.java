import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int minDiff = 1000;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            minDiff = Math.min(minDiff, Math.abs(arr[i] - B));
        }

        System.out.println(Math.min(Math.abs(A - B), minDiff + 1));
    }
}