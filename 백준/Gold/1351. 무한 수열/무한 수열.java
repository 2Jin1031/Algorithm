import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static long N;
    private static HashMap<Long, Long> map;
    private static long P, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map = new HashMap<>();

        map.put(0L, 1L);

        long result = 1;
        if (N > 0) {
            result = dp(N / P) + dp(N / Q);
        }
        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static long dp(long value) {
        if (map.containsKey(value)) {
            return map.get(value);
        }

        long result = dp(value / P) + dp(value / Q);
        map.put(value, result);
        return result;
    }
}