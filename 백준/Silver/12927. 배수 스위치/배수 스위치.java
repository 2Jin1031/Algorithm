import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();

        boolean[] bulb = new boolean[n + 1];
        for (int i = 1; i <= n; i++) bulb[i] = (s.charAt(i - 1) == 'Y');

        int press = 0;
        for (int i = 1; i <= n; i++) {
            if (bulb[i]) {
                press++;
                for (int j = i; j <= n; j += i) bulb[j] = !bulb[j];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (bulb[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(press);
    }
}