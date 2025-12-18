import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer("");
        long prefix = 0L;
        long ans = 0L;

        int cnt = 0;
        while (cnt < n) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            long a = Long.parseLong(st.nextToken());
            ans += prefix * a;
            prefix += a;
            cnt++;
        }

        System.out.print(ans);
    }
}