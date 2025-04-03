import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int minValue = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                int value = Integer.parseInt(st.nextToken());
                if (value % 2 == 0) {
                    sum += value;
                    minValue = Math.min(minValue, value);
                }
            }
            System.out.println(sum + " " + minValue);
        }
    }
}