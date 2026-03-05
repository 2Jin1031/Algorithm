import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int len = br.readLine().length();
            sb.append(len >= 6 && len <= 9 ? "yes" : "no").append('\n');
        }

        System.out.print(sb);
    }
}