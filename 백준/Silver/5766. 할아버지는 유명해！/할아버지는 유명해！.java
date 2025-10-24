import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            Map<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    freq.put(num, freq.getOrDefault(num, 0) + 1);
                }
            }

            Set<Integer> set = new HashSet<>(freq.values());
            List<Integer> values = new ArrayList<>(set);
            values.sort(Collections.reverseOrder());

            int second = (values.size() >= 2) ? values.get(1) : 0;

            List<Integer> ans = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                if (e.getValue() == second) ans.add(e.getKey());
            }

            Collections.sort(ans);
            StringBuilder sb = new StringBuilder();
            for (int x : ans) sb.append(x).append(' ');
            sb.append('\n');
            System.out.print(sb);
        }
    }
}