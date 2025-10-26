import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Map<Integer, String> map = new TreeMap();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String questionTitle = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            map.put(num, questionTitle.charAt(level - 1) + "");
        }

        StringBuilder sb = new StringBuilder();
        for (int key : map.keySet()) {
            sb.append(map.get(key).toUpperCase());
        }
        System.out.print(sb);
    }
}