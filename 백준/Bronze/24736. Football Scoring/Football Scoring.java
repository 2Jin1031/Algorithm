import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int calc(StringTokenizer st) {
        int T = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        return 6*T + 3*F + 2*S + P + 2*C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int visiting = calc(st1);
        int home = calc(st2);

        System.out.println(visiting + " " + home);
    }
}