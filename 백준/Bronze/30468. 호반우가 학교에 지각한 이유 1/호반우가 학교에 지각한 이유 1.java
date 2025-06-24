import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        double avg = sum / (4 + 0.0);

        double N = Integer.parseInt(st.nextToken()) + 0.0;

        double result = (N - avg) / 0.25;

        int ans = (int)result;
        if ((N - avg) % 0.25 > 0) {
            ans++;
        }

        if (N < avg) ans = 0;
        System.out.println(ans);
    }
}