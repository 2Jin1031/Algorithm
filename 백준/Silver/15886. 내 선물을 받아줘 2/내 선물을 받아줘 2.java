import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int ans = 0;
        for (int i = 1; i < N; i++) {
            if (input.charAt(i - 1) == 'E' && input.charAt(i) == 'W') {
                ans++;
            }
        }
        System.out.println(ans);
    }
}