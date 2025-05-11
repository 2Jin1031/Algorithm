import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int H = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());

        double minLength = Math.min(H, W) + 0.0;
        int ans = (int) (minLength / 2 * 100);
        System.out.println(ans);
    }
}