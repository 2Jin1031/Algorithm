import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static int N, S;
    private static int[] arr;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            backtracking(arr[i], i);    
        }

        System.out.println(count);
    }

    private static void backtracking(int sum, int idx) {
        if (sum == S) {
            count++;
        }

        for (int i = idx + 1; i < N + 1; i++) {
            backtracking(sum + arr[i], i);
        }
    }
}
