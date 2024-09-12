import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] ascendingDP;
    private static int[] descendingDP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    ascendingDP[i] = Math.max(ascendingDP[i], ascendingDP[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    descendingDP[i] = Math.max(descendingDP[i], descendingDP[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, ascendingDP[i] + descendingDP[i] - 1);
        }

        bw.write(String.valueOf(max));

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ascendingDP = new int[N];
        descendingDP = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(ascendingDP, 1);
        Arrays.fill(descendingDP, 1);
    }


}