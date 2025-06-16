import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 123456 * 2;

    public static void main(String[] args) throws IOException {
        boolean[] isPrime = makePrimes(MAX);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i]) count++;
            }
            System.out.println(count);
        }
    }

    private static boolean[] makePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= limit; j += i) {
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
}