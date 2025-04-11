import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minUnitPrice = Integer.MAX_VALUE;
        int minPerPrice = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int unitPrice = Integer.parseInt(st.nextToken());
            int perPrice = Integer.parseInt(st.nextToken());

            minUnitPrice = Math.min(minUnitPrice, unitPrice);
            minUnitPrice = Math.min(minUnitPrice, perPrice * 6);
            minPerPrice = Math.min(minPerPrice, perPrice);
        }

        int div = N / 6;
        int rest = N % 6;

        int divPrice = div * minUnitPrice;
        int restPrice = Math.min(rest * minPerPrice, minUnitPrice);
        int totalPrice = divPrice + restPrice;
        System.out.println(totalPrice);
    }
}