import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] heights = readHeights(br, N);
        long answer = calculateMinCost(heights, N, K);

        System.out.print(answer);
    }

    static long[] readHeights(BufferedReader br, int N) throws Exception {
        long[] a = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        return a;
    }

    static long calculateMinCost(long[] a, int N, int K) {
        if (K == N) return 0;

        long[] diff = buildDiff(a, N);
        Arrays.sort(diff);

        long total = a[N - 1] - a[0];
        long cutSum = sumLargestGaps(diff, N, K);

        return total - cutSum;
    }

    static long[] buildDiff(long[] a, int N) {
        long[] diff = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = a[i + 1] - a[i];
        }
        return diff;
    }

    static long sumLargestGaps(long[] diff, int N, int K) {
        long sum = 0;
        for (int i = 0; i < K - 1; i++) {
            sum += diff[(N - 2) - i];
        }
        return sum;
    }
}