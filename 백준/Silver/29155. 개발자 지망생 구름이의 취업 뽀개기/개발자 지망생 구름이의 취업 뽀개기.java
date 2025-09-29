import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sizes = new int[6];
        for (int i = 1; i < 6; i++) {
            int num =  Integer.parseInt(st.nextToken());
            sizes[i] = num;
            map.put(i, new ArrayList<>(num));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            List<Integer> list = map.get(k);
            list.add(t);
        }

        int ans = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            Collections.sort(list);

            ans += list.get(0);
            for (int i = 1; i < sizes[key]; i++) {
                ans += list.get(i) - list.get(i - 1);
                ans += list.get(i);
            }
            ans += 60;
        }
        System.out.println(ans - 60);
    }
}