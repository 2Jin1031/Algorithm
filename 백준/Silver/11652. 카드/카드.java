import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        long result = 0;
        int maxCount = 0;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            long card = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && card < result)) {
                maxCount = count;
                result = card;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}