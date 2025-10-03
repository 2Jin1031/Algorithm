import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            String s = br.readLine().trim();
            int n = (int) Math.sqrt(s.length());
            char[][] a = new char[n][n];

            int idx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = s.charAt(idx++);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.append(a[j][n - 1 - i]);
                }
            }
            if (T > 0) out.append('\n');
        }

        System.out.print(out.toString());
    }
}