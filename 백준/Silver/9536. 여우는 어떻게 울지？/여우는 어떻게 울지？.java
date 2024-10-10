import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            HashMap<String, List<Integer>> map = new HashMap<>();
            String[] crying = br.readLine().split(" ");
            for (int i = 0; i < crying.length; i++) {
                if (map.containsKey(crying[i])) {
                    List<Integer> list = new ArrayList<>(map.get(crying[i]));
                    list.add(i);
                    map.put(crying[i], list);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(crying[i], list);
                }
            }

            while(true) {
                String[] info = br.readLine().split(" ");
                if (info[0].equals("what")) {
                    break;
                }
                map.remove(info[2]);
            }

            String[] result = new String[crying.length];
            for (String key : map.keySet()) {
                List<Integer> list = map.get(key);
                for (int i = 0; i < list.size(); i++) {
                    result[list.get(i)] = key;
                }
            }

            for (int i = 0; i < result.length; i++) {
                if (result[i] != null)
                    bw.write(result[i] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}