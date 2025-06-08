import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        String ans = "";
        if (q > 30) {
            ans = "Red";
        } else if (p <= 50 && q <= 10) {
            ans = "White";
        } else {
            ans = "Yellow";
        }

        System.out.println(ans);
    }
}