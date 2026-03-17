import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            String str = st.nextToken();
            strs[i] = str;
        }

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (strs[0].equals("0")) {
                System.out.println("0");
                return ;
            }
            sb.append(strs[i]);
        }

        System.out.print(sb);
    }
}