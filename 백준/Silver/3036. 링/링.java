import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int src = arr[0];
        for (int i = 1; i < N; i++) {
            int value = arr[i];
            int gcd = getGreatestCommonDivisor(src, value);
            System.out.println(String.format("%d/%d", src/gcd, value/gcd));
        }
    }

    private static int getGreatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        int r = a % b;
        return getGreatestCommonDivisor(b, r);
    }
}
