import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}