import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int a3 = Integer.parseInt(st.nextToken());

            if (a1 == 0 && a2 == 0 && a3 == 0) break;

            String ansStr = "";
            int ansInt = 0;
            if (a1 + a3 == a2 * 2) {
                ansStr = "AP";
                ansInt = a3 + (a3 - a2);
            } else {
                ansStr = "GP";
                ansInt = a3 * (a3 / a2);
            }

            System.out.println(String.format("%s %d", ansStr, ansInt));
        }
        
    }
}