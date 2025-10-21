import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String p = st.nextToken();

            int addDiff = 0;
            int pLength = p.length();

            int count = 0;
            for (int i = 0; i + pLength <= s.length(); i += addDiff) {
                String str = s.substring(i, i + pLength);
                if (p.equals(str)) {
                    count++;
                    addDiff = pLength;
                } else {
                    addDiff = 1;
                }
            }
            int ans = s.length() - pLength * count + count;
            System.out.println(ans);
        }
    }
}