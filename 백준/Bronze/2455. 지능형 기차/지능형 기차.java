import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCount = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int outCount = Integer.parseInt(st.nextToken());
            int inCount = Integer.parseInt(st.nextToken());
            totalCount = totalCount - outCount + inCount;
            maxCount = Math.max(maxCount, totalCount);
        }
        System.out.println(maxCount);
    }
}