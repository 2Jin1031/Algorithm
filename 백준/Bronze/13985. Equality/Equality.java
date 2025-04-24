import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int num1 = Integer.parseInt(input.charAt(0) + "");
        int num2 = Integer.parseInt(input.charAt(4) + "");

        int sum = Integer.parseInt(input.charAt(8) + "");

        int expected = num1 + num2;

        String ans = "";
        if (expected == sum) {
            ans = "YES";
        } else {
            ans = "NO";
        }

        System.out.println(ans);
    }
}