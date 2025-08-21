import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int maxScore = arr[N - 1];
            int minScore = arr[0];
            int maxDiff = 0;
            for (int i = 1; i < N; i++) {
                int diff = arr[i] - arr[i - 1];
                maxDiff = Math.max(maxDiff, diff);
            }
            System.out.println("Class " + (k + 1));
            System.out.println(String.format("Max %d, Min %d, Largest gap %d", maxScore, minScore, maxDiff));
        }
    }
}
