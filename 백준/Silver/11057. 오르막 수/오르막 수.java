import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new long [N][11];
        Arrays.fill(arr[0], 1);
        arr[0][10] = 10;
        for (int i = 1; i < N; i++) {
            arr[i][0] = arr[i - 1][10];
            long sum = arr[i][0];
            for (int j = 1; j < 10; j++) {
                arr[i][j] = ((arr[i][j - 1] - arr[i - 1][j - 1]) % 10007 + 10007) % 10007;
                sum += arr[i][j];
            }
            arr[i][10] = sum % 10007;
        }

        bw.write(String.valueOf(arr[N - 1][10]));

        br.close();
        bw.close();
    }
}
