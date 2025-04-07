import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        }
        int result = minValue * maxValue;
        System.out.println(result);
    }
}