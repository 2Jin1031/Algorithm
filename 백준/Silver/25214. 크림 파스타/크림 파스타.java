import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        
        StringBuilder sb = new StringBuilder();
        int minValue = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            minValue = Math.min(minValue, num);
            maxDiff = Math.max(maxDiff, num - minValue);

            sb.append(maxDiff).append(" ");
        }

        System.out.print(sb);
    }
}