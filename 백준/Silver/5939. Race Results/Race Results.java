import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] a = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
            a[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, (x, y) -> {
            int c0 = Integer.compare(x[0], y[0]);
            if (c0 != 0) return c0;
            int c1 = Integer.compare(x[1], y[1]);
            if (c1 != 0) return c1;
            return Integer.compare(x[2], y[2]);
        });

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < N; i++) {
            out.append(a[i][0]).append(' ')
               .append(a[i][1]).append(' ')
               .append(a[i][2]).append('\n');
        }
        System.out.print(out);
    }
}