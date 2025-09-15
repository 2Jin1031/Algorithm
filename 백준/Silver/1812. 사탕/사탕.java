import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        for (int num = 0; num <= arr[0]; num++) {
            int candy = num;
            for (int i = 1; i < N; i++) {
                candy = arr[i - 1] - candy;
            }
            if (num + candy == arr[N - 1]) {
                StringBuilder sb = new StringBuilder();
                candy = num;
                sb.append(candy).append('\n');
                for (int i = 1; i < N; i++) {
                    candy = arr[i - 1] - candy;
                    sb.append(candy).append('\n');
                }
                System.out.print(sb.toString());
                return;
            }
        }
    }
}