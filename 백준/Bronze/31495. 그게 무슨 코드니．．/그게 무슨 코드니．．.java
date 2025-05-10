import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String ans = "";
        if (input.length() <= 2 || input.charAt(0) != '\"' || input.charAt(input.length() - 1) != '\"') {
            ans = "CE";
        } else {
            ans = input.substring(1, input.length() - 1);
        }
        System.out.println(ans);
    }
}