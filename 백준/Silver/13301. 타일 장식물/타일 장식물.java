import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int minValue = Math.min(4, N + 2);
        long[] arr = new long[N + 2];
        long[] init = new long[4];
        init[0] = 1;
        init[1] = 1;
        init[2] = 1;
        init[3] = 2;
        System.arraycopy(init, 0, arr, 0, minValue);

        for (int i = 4; i < N + 2; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        long result = (arr[N + 1] + arr[N]) * 2;
        bw.write(String.valueOf(result));

        bw.close();
        br.close();

    }
}