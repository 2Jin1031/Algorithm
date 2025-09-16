import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] arr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        TreeMap<String, String> map = new TreeMap<>();
        for (int i = M; i <= N; i++) {
            String numStr = String.valueOf(i);
            String key = "";
            for (int j = 0; j < numStr.length(); j++) {
                String str = numStr.charAt(j) + "";
                key += arr[Integer.parseInt(str)];
            }

            map.put(key, numStr);
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(map.get(key));
            idx++;

            if (idx % 10 == 0) {
                sb.append("\n");
            } else {
                sb.append(" "); 
            }
        }

        System.out.println(sb.toString());
    }
}