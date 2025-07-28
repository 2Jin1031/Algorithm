import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double minValue = Double.MAX_VALUE;
        double firstValue = Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken());
        minValue = Math.min(minValue, firstValue);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double currentValue = Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken());
            minValue = Math.min(minValue, currentValue);
        }

        System.out.println(String.format("%.2f", minValue * 1000));
    }
}