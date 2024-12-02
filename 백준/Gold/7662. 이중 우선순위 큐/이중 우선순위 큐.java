import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else { // command.equals("D")
                    if (map.isEmpty()) continue;

                    if (number == -1) {
                        // 최솟값 제거
                        int minKey = map.firstKey();
                        if (map.put(minKey, map.get(minKey) - 1) == 1) {
                            map.remove(minKey);
                        }
                    } else { // number == 1
                        // 최댓값 제거
                        int maxKey = map.lastKey();
                        if (map.put(maxKey, map.get(maxKey) - 1) == 1) {
                            map.remove(maxKey);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }

        bw.close();
        br.close();
    }
}