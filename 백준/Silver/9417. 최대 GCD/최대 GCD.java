import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[99];
            int idx = 0;
            while(st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            int maxGDC = 0;
            for (int i = 0; i < idx; i++) {
                for (int j = i + 1; j < idx; j++) {
                    int gdc = getGDC(arr[i], arr[j]);
                    maxGDC = Math.max(maxGDC, gdc);
                }
            }
            System.out.println(maxGDC);
        }
    }

    private static int getGDC(int a, int b) {
        if (b == 0) {
            return a;
        }

        int r = a % b;
        return getGDC(b, r);
    }
}
