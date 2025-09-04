import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        String ans1 = "";
        int ans2 = 0;
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (ans2 <= value) {
                ans2 = value;
                ans1 = key;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
