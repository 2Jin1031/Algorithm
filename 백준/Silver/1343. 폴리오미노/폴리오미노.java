import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int i = 0;
        String ans = "";
        while (i < input.length()) {
            if (input.charAt(i) == '.') {
                ans += ".";
                i++;
                continue;
            }

            int start = i;
            while (i < input.length() && input.charAt(i) == 'X') {
                i++;
            }

            int length = i - start;
            if (length % 2 != 0) {
                System.out.println("-1");
                return;
            }

            while (length >= 4) {
                ans += "AAAA";
                length -= 4;
            }
            while (length >= 2) {
                ans += "BB";
                length -= 2;
            }
        }
        System.out.println(ans);
    }
}