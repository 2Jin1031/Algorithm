import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boolean isPalindrome = true;
            while (start < end) {
                if (!dp[start][end]) {
                    isPalindrome = false;
                    break;
                }
                start++;
                end--;
            }
            bw.write(isPalindrome ? "1\n" : "0\n");
        }

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = true;
                }
            }
        }
    }
}
