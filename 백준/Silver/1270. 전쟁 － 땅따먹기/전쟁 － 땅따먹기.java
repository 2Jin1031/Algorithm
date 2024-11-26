import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            int T;
            HashMap<Long, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            for (int j = 0; j < T; j++) {
                long value = Long.valueOf(st.nextToken());
                map.putIfAbsent(value, 0);
                map.put(value, map.get(value) + 1);
            }

            int majority = (T / 2);
            boolean flag = false;
            for (long key : map.keySet()) {
                if (map.get(key) > majority) {
                    bw.write(key + "\n");
                    flag = true;
                }
            }

            if (!flag) {
                bw.write("SYJKGW\n");
            }
        }

        bw.close();
        br.close();
    }
}