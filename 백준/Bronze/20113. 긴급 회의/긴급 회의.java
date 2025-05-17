import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value == 0) continue;
            map.computeIfAbsent(value, k -> 0);
            map.put(value, map.get(value) + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());

        keySet.sort(new Comparator<Integer>() {
            @Override
                public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        int maxFirstValue = map.get(keySet.get(0));
        int maxSecondValue = map.get(keySet.get(1));
        if (maxFirstValue == maxSecondValue) {
            System.out.println("skipped");
            return ;
        }

        System.out.println(keySet.get(0));
    }
}