import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        HashMap<String, List<String>> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            int count = Integer.parseInt(br.readLine());
            List<String> members = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                members.add(br.readLine());
            }
            sort(members);
            map.put(group, members);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            String type = br.readLine();
            if (type.equals("1")) {
                for (String key : map.keySet()) {
                    if (map.get(key).contains(name)) {
                        bw.write(key + "\n");
                        break;
                    }
                }
            } else {
                bw.write(String.join("\n", map.get(name)) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}