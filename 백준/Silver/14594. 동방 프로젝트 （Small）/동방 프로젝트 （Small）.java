import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        boolean[] removed = new boolean[N + 1];

        for (int k = 0; k < M; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int i = x; i < y; i++) removed[i] = true;
        }

        int removedCount = 0;
        for (int i = 1; i <= N - 1; i++) if (removed[i]) removedCount++;
        System.out.println(N - removedCount);
    }
}