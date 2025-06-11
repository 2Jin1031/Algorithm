import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 84;

        String input = br.readLine();
        ans += Math.abs('I' - input.charAt(0));

        System.out.println(ans);
    }
}