import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            String ans = "";
            if (e > r + c) {
                ans = "advertise";
            } else if (e == r + c) {
                ans = "does not matter";
            } else {
                ans = "do not advertise";
            }

            System.out.println(ans);
        }
    }
}