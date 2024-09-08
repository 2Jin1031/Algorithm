import java.io.*;
import java.lang.reflect.Array;

import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sort(arr, 0, N);
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.close();
        br.close();

    }
}