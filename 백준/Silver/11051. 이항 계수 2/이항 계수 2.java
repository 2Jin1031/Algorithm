import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 팩토리얼 계산 배열
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = (dp[i - 1] * i) % MOD;
        }

        // 이항계수 계산
        int result = (dp[N] * modInverse(dp[K], MOD) % MOD) * modInverse(dp[N - K], MOD) % MOD;
        bw.write(result + "\n");

        bw.close();
        br.close();
    }

    // 모듈러 역수를 구하는 함수 (페르마의 소정리 이용)
    static int modInverse(int a, int mod) {
        return pow(a, mod - 2, mod);
    }

    // 거듭제곱 계산 함수 (모듈러 거듭제곱)
    static int pow(int a, int exp, int mod) {
        int result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            exp /= 2;
        }
        return result;
    }
}