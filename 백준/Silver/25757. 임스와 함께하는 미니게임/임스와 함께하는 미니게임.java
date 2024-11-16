import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Y", 1);
        map.put("F", 2);
        map.put("O", 3);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            set.add(name);
        }

        bw.write(set.size() / map.get(gameType) + "\n");
        bw.close();
        br.close();
    }
}