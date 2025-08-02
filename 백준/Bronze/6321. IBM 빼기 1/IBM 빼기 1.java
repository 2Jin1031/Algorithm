import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            String ans = "";
            for (int j = 0; j < input.length(); j++) {
                char str = input.charAt(j);
                if (str == 'Z') {
                    ans += "A";
                } else {
                    ans += (char)(str + 1);
                }
            }
            System.out.println(String.format("String #%d", i + 1));
            System.out.println(ans);
            System.out.println();
        }
    }
}