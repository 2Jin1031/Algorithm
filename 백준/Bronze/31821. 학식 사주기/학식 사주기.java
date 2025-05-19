import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int M = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(br.readLine());
            ans += arr[number];
        }

        System.out.println(ans);
    }
}