import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        TreeMap<String, Integer> map = new TreeMap<>();
        int count = 0;
        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) {
                break;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
            count++;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.write(entry.getKey() + " " + String.format("%.4f", (double) entry.getValue() / count * 100) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
