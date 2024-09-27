import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
        }

        LinkedList<String> list = new LinkedList<>(map.keySet());
        list.sort((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o1.compareTo(o2);
            }
            return map.get(o2) - map.get(o1);
        });

        bw.write(list.get(0));
        br.close();
        bw.close();
    }
}