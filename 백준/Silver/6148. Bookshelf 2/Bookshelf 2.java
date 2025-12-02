import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int B = Integer.parseInt(first[1]);

        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }

        int limit = 1 << N;             
        int answer = Integer.MAX_VALUE;  

        for (int mask = 0; mask < limit; mask++) {
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += h[i];
                }
            }

            if (sum >= B) {
                int diff = (int)(sum - B);
                if (diff < answer) {
                    answer = diff;
                }
            }
        }

        System.out.println(answer);
    }
}