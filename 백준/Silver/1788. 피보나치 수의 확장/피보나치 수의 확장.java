import java.io.*;

public class Main {

    private static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int absN = Math.abs(N);
        int[] arr = new int[absN + 1];

        arr[0] = 0;
        if (absN > 0) arr[1] = 1;

        for (int i = 2; i <= absN; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % INF;
        }

        int result = arr[absN];

        if (N < 0 && N % 2 == 0) {
            result = -result;
        }

        int sign = Integer.compare(result, 0);
        bw.write(sign + "\n");

        bw.write(Math.abs(result) % INF + "\n");

        bw.close();
        br.close();
    }
}