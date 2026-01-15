import java.io.*;
import java.util.*;

public class Main {

    private static double[] arr = new double[]{350.34, 230.90, 190.55, 125.30, 180.90};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            double ans = 0.0;

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < arr.length; i++) {
                ans += Long.parseLong(st.nextToken()) * arr[i];
            }

            System.out.printf("$%.2f\n", ans);
        }
    }
}