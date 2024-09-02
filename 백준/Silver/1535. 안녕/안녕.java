import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] power;
    private static int[] happy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int[] dp = new int[100];

        for (int i = 0; i < N; i++) {
            for (int j = 99; j >= power[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - power[i]] + happy[i]);
            }
        }
        bw.write(dp[99] + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {

        N = Integer.parseInt(br.readLine());

        power = new int[N];
        happy = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }
    }
}