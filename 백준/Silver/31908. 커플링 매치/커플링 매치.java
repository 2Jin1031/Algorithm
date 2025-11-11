import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Map<String, List<String>> map = new HashMap<>();

        StringTokenizer st;

        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String key = st.nextToken();

            List<String> names = map.getOrDefault(key, new ArrayList<>());
            if (names.size() == 2 && !key.equals("-")) {
                count--;
            } else if (names.size() == 1 && !key.equals("-")) {
                count++;   
            }
            names.add(name);
            map.put(key, names);
        }

        System.out.println(count);
        if (count == 0) return ;
        for (String key : map.keySet()) {
            List<String> names = map.get(key);
            if (names.size() == 2 && !key.equals("-")) {
                String ans = "";
                for (int i = 0; i < names.size(); i++) {
                    ans += names.get(i) + " ";
                }
                System.out.println(ans);
            }
        }
    }
}