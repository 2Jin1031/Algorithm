import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] requiredDays;
    private static int[] pages;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int[] dp = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = N; j >= requiredDays[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - requiredDays[i]] + pages[i]);
            }
        }
        bw.write(dp[N] + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        requiredDays = new int[M + 1];
        pages = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            requiredDays[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }
    }
}