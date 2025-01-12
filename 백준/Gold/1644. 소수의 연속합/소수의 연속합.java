import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static boolean[] isPrime;
    private static int primeCount;
    private static int[] arr;
    private static int[] sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        eratosthenesSieve(N);
        arr = new int[primeCount + 1];
        sumArr = new int[primeCount + 1];

        int index = 1;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                arr[index] = i;
                sumArr[index] = sumArr[index - 1] + i;
                index++;
            }
        }

        int left = 0;
        int right = 1;
        int answer = 0;

        while (left < right && right < arr.length) {
            int sum = sumArr[right] - sumArr[left];

            if (sum == N) {
                answer++;
                left++;
            } else if (sum < N) {
                right++;
            } else {
                left++;
            }
        }

        System.out.println(answer);

    }

    private static void eratosthenesSieve(int N) {
        isPrime = new boolean[N + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }
    }
}