import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean lB, kB, pB;
        lB = false;
        kB = false;
        pB = false;
        
        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            if (input.startsWith("k")) {
                kB = true;
            } else if (input.startsWith("l")) {
                lB = true;
            } else if (input.startsWith("p")) {
                pB = true;
            }
        }

        String ans = "";
        if (lB && kB && pB) {
            ans = "GLOBAL";
        } else {
            ans = "PONIX";
        }

        System.out.println(ans);
    }
}