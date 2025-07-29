import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            boolean result = is90(a, b, c);
            String ans = "";
            if (result) {
                ans = "yes";
            } else {
                ans = "no"; 
            }
            System.out.println(String.format("Scenario #%d:", i + 1));
            System.out.println(ans);
            System.out.println();
        }
    }

    private static boolean is90(int a, int b, int c) {
        int maxValue = Math.max(Math.max(a, b), c);
            if (maxValue == a) {
                if (a * a == b * b + c * c) {
                    return true;        
                }
                return false;
                
            } else if (maxValue == b) {
                if (b * b == a * a + c * c) {
                    return true;
                }
                return false;
            } else {
                if (c * c == a * a + b * b) {
                    return true;
                }
                return false;
            }
    }
}