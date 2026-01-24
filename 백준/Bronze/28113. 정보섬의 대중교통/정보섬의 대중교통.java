import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String ans = "Bus";
        if (N <= B) {
            if (A < B) ans = "Bus";
            else if (A == B) ans = "Anything";
            else ans = "Subway";
        } 

        System.out.println(ans);
    }
}